package toy.test.mySql.dao;

import common.entity.SmallToyEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 测试rowBounds
     *
     * @param rowBounds 分页条件
     * @return 分页后的结果
     */
    List<SmallToyEntity> testRowBounds(RowBounds rowBounds);

    /**
     * 测试默认时间以Map的形式取出来是否为null
     *
     * @return Map
     */
    List<Map<String, Object>> testZeroTime();

    /**
     * 插入记录
     *
     * @param smallToyEntity SmallToyEntity
     */
    void insertSmallToy(SmallToyEntity smallToyEntity);
}
