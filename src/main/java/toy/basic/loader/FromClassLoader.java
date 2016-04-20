package toy.basic.loader;

import java.io.InputStream;

/**
 * 从类加载器载入资源
 *
 * Created by cc on 16/4/20.
 */
public class FromClassLoader {

    public static void main(String[] args) {
        /**
         * 带有/时并不能在根目录找到资源 可以避免使用这种方式
         */
        InputStream withRoot = FromClassLoader.class.getClassLoader().getResourceAsStream("/log4j.properties");
        InputStream withoutRott = FromClassLoader.class.getClassLoader().getResourceAsStream("log4j.properties");

        if (withRoot != null) {
            System.out.println("find with root");
        }

        if (withoutRott != null) {
            System.out.println("find without root");
        }
    }
}
