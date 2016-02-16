package aspect;

import javax.annotation.Resource;

import org.junit.Test;

import toy.aspect.AspectMain;

import common.BaseTest;

/**
 * AspectTest
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午1:08
 */
public class AspectTest extends BaseTest {

    @Resource
    AspectMain aspectMain;

    @Test
    public void testAspect() {
        try {
            aspectMain.sayHi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        aspectMain.helloWorld();
        aspectMain.sayHello();
    }
}
