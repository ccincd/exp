package test.mySql.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import toy.test.mySql.dao.TestMySqlDataSourceDao;

import common.TxRollBackBaseTest;

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
}
