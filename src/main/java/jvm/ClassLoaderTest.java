package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器测试
 *
 * Created by cc on 16/6/5.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        final ClassLoader myLoader = new ClassLoader() {
            @Override public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf('.') + 1) + ".class";

                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }

                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = myLoader.loadClass("jvm.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof jvm.ClassLoaderTest);
    }
}
