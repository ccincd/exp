package toy.test.crate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TestCrateMySqlDataSourceDao
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午6:05
 */
@Repository
public interface TestCrateDataSourceDao {

    void insertOne(@Param("first") Integer firstColumn, @Param("second") String secondColumn);
}
