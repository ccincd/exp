package common;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * TxBaseTest
 *
 * @author chi.chen
 * @date 16-2-2
 * @time 下午3:26
 */
@Transactional("txManager")
@Rollback(true)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TxRollBackBaseTest {
}
