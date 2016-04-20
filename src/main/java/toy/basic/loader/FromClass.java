package toy.basic.loader;

import java.io.InputStream;

/**
 * 从类载入资源
 * 内部会调用ClassLoader的getResourceAsStream
 * 以包名路径来进行查找
 *
 * Created by cc on 16/4/20.
 */
public class FromClass {

    public static void main(String[] args) {
        InputStream inputStream = FromClass.class.getResourceAsStream("hi.txt");

        if (inputStream != null) {
            System.out.println("hi, there");
        }
    }
}
