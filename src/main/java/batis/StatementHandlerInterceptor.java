/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package batis;

import common.utils.ReflectUtil;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author chichen  Date: 16-4-20 Time: 下午3:22
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class})})
public class StatementHandlerInterceptor implements Interceptor {

    private Dialect dialect;

    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if(target instanceof RoutingStatementHandler) {
            target = ReflectUtil.getFieldValue(target, "delegate");
        }

        RowBounds rowBounds = (RowBounds) ReflectUtil.getFieldValue(target, "rowBounds");
        if(rowBounds.getLimit() > 0 && rowBounds.getLimit() < Integer.MAX_VALUE) {
            BoundSql boundSql = ((StatementHandler) target).getBoundSql();
            String sql = boundSql.getSql();
            sql = this.dialect.getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());
            ReflectUtil.setFieldValue(boundSql, "sql", sql);
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        String dialectClass = properties.getProperty("dialectClass");
        if(dialectClass != null && !dialectClass.isEmpty()) {
            try {
                this.dialect = (Dialect) Class.forName(dialectClass).newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid dialect class " + dialectClass, e);
            }
        } else {
            this.dialect = new DefaultDialect();
        }
    }
}
