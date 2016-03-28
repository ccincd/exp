package concurrency.java.uncaught;

/**
 * 抛出unchecked异常的Thread
 * extends Thread或者implements Runnable
 *
 * Created by cc on 16/3/28.
 */
public class UncaughtThread extends Thread {

    @Override public void run() {
        System.out.println("hi, there");

        throw new RuntimeException("oops");
    }
}
