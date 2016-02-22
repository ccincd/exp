package toy.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchDemo
 *
 * @author chi.chen
 * @date 16-2-18
 * @time 下午1:36
 */
public class CountDownLatchDemo {

    private static int COUNT_NUM = 3;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT_NUM);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < COUNT_NUM; i++) {
            executorService.submit(new RunnableTest(countDownLatch));
            // countDownLatch.countDown();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("come here");
        executorService.shutdown();
    }
}
