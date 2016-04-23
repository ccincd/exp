package concurrency.java.synchronizers;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 工作线程
 *
 * Created by cc on 16/4/23.
 */
public class WorkerThread extends Thread {

    private CountDownLatch countDownLatch;

    public WorkerThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override public void run() {
        // do some stuff
        long sum = 0L;
        Random random = new Random();
        int randomRange = random.nextInt(Integer.MAX_VALUE);
        for (int i = 0; i < randomRange; i++) {
            boolean plusOrMinus = random.nextBoolean();
            if (!plusOrMinus) {
                sum += -i;
            } else {
                sum += i;
            }
        }

        System.out.println(sum);
        countDownLatch.countDown();
    }
}
