package concurrency.java;

/**
 * ThreadLocal测试
 *
 * Created by cc on 16/5/29.
 */
public class ThreadLocalTest {

    private ThreadLocal<String> name = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "hi, there";
        }
    };

    public String getName() {
        return name.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        System.out.println(threadLocalTest.getName());
    }
}
