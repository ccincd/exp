package concurrency.java.uncaught;

/**
 * 测试类
 *
 * Created by cc on 16/3/28.
 */
public class TestUncaught {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId()
                + "\n" + Thread.currentThread().getName());

        UncaughtThread uncaughtThread = new UncaughtThread();
        uncaughtThread.setUncaughtExceptionHandler(new UncaughtHandler());

        // uncaughtThread.run();
        uncaughtThread.start();
    }
}
