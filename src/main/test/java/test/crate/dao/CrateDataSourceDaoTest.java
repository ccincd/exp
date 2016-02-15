package test.crate.dao;

import javax.annotation.Resource;

import org.junit.Test;

import common.BaseTest;

/**
 * CrateDataSourceDao
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午6:13
 */
public class CrateDataSourceDaoTest extends BaseTest {

    @Resource
    TestCrateDataSourceDao dataSourceDao;

    @Test
    public void testDataSource() {
        try {
            dataSourceDao.insertOne(9, "Happy");

            System.out.println("Hi~");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
