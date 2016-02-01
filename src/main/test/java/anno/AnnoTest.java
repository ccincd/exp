package anno;

import javax.annotation.Resource;

import org.junit.Test;

import common.BaseTest;

/**
 * AnnoTest
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午5:30
 */
public class AnnoTest extends BaseTest {

    @Resource
    AnnoMain annoMain;

    @Test
    public void doTest() {
        annoMain.helloAnno();
    }
}
