package toy.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * RunnableTest
 *
 * @author chi.chen
 * @date 16-2-18
 * @time 下午1:37
 */
public class RunnableTest implements Runnable {

    private CountDownLatch countDownLatch;

    public RunnableTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getName() + " is running.");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
