package concurrency.java.cancellation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 测试执行Cancel之后 Work线程在不调用阻塞方法的情况下会不会被取消
 *
 * Created by cc on 16/5/4.
 */
public class FutureCancellation {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable heavyTask = new Runnable() {
            @Override public void run() {
                while (true) {
                    System.out.println("hi, there");
                }
            }
        };

        Future future = executorService.submit(heavyTask);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean cancelResult = future.cancel(true);
        System.out.println(cancelResult);

        /**
         * 线程操作的wait()、notify()、notifyAll()方法只能在同步控制方法或同步控制块内调用
         * 必须拥有对象的锁才可以
         */
        synchronized (executorService) {
            try {
                executorService.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
