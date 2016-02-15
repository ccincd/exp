package test.mySql.dao;

import org.springframework.stereotype.Repository;

/**
 * testDataSourceDao
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午3:00
 */
@Repository
public interface TestMySqlDataSourceDao {

    /**
     * 测试dataSource连接
     *
     * @return 记录数
     */
    int countSmallToys();
}
