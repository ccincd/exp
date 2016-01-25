package XA;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

import javax.sql.XADataSource;

/**
 * Commons
 *
 * @author chi.chen
 * @date 16-1-25
 * @time 下午12:28
 */
public class Commons {

    public static XADataSource getDataSource(String url, String user, String password) {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
