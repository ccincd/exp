package test.mySql.dao;

import javax.annotation.Resource;

import common.entity.SmallToyEntity;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;

import toy.test.mySql.dao.TestMySqlDataSourceDao;

import common.TxRollBackBaseTest;

import java.util.List;

/**
 * DataSourceTest
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午3:25
 */
public class MySqlDataSourceTest extends TxRollBackBaseTest {

    @Resource
    TestMySqlDataSourceDao dataSourceDao;

    @Test
    public void testDataSource() {
        try {
            int counter = dataSourceDao.countSmallToys();
            Assert.assertEquals(counter, 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRowBounds() {
        // offside, limit (pageSize)
        RowBounds rowBounds = new RowBounds(0, 3);

        List<SmallToyEntity> smallToyEntities = dataSourceDao.testRowBounds(rowBounds);
        System.out.println(smallToyEntities);
    }
}
