package concurrency.java.uncaught;

/**
 * Thread中抛出的unchecked异常处理回调
 *
 * Created by cc on 16/3/28.
 */
public class UncaughtHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("id: " + t.getId() + "\n" + t.getName());
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
