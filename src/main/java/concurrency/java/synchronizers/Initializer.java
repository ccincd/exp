package concurrency.java.synchronizers;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 做初始化工作的线程
 *
 * Created by cc on 16/4/23.
 */
public class Initializer extends Thread {

    private CountDownLatch countDownLatch;

    public Initializer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override public void run() {
        Random random = new Random();
        while (random.nextInt(100000) != 9527) {
            System.out.println("not me!");
        }

        countDownLatch.countDown();
    }
}
