package toy.properties;

import java.io.InputStream;

/**
 * ReadPropertiesTest
 *
 * @author chi.chen
 * @date 16-2-22
 * @time 下午6:25
 */
public class ReadPropertiesTest {

    private static final String resourceName = "config/ApplicationResources.properties";

    public static void main(String[] args) {
        InputStream inputStreamGlobal = ReadPropertiesTest.class.getClassLoader().getResourceAsStream(resourceName);
        // InputStream inputStreamLocal = ReadPropertiesTest.class.getResourceAsStream(resourceName);
        InputStream inputStreamLocal = ReadPropertiesTest.class.getResourceAsStream("/toy/properties/" + resourceName);
        String packagePath = ReadPropertiesTest.class.getResource("").getPath();

        System.out.println(packagePath);
        System.out.println(inputStreamGlobal);
        System.out.println(inputStreamLocal);
    }
}
