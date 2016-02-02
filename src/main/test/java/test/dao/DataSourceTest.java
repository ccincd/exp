package test.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import common.TxRollBackBaseTest;

/**
 * DataSourceTest
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午3:25
 */
public class DataSourceTest extends TxRollBackBaseTest {

    @Resource
    TestDataSourceDao dataSourceDao;

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
