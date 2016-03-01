package test;

import java.io.InputStream;

import org.junit.Test;

import common.BaseTest;

/**
 * ReadPropertiesTest
 *
 * @author chi.chen
 * @date 16-2-22
 * @time 下午6:30
 */
public class ReadPropertiesTest extends BaseTest {

    private static final String resourceName = "config/ApplicationResources.properties";

    @Test
    public void testResourceLoading() {
        InputStream inputStreamGlobal = ReadPropertiesTest.class.getClassLoader().getResourceAsStream(resourceName);
        InputStream inputStreamLocal = ReadPropertiesTest.class.getResourceAsStream(resourceName);
        String packagePath = this.getClass().getResource("").getPath();

        System.out.println(packagePath);
        System.out.println(inputStreamGlobal);
        System.out.println(inputStreamLocal);
    }
}
