package concurrency.java.synchronizers;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * 测试门闩
 * 门闩是一种Synchronize(r) 其内部维护状态 向外提供方法
 *
 * Created by cc on 16/4/23.
 */
public class TestLatch {

    private static final Integer WORKERS_NUM = 5;

    public static void main(String[] args) {
        CountDownLatch prerequisite = new CountDownLatch(1);
        CountDownLatch postRequisite = new CountDownLatch(WORKERS_NUM);

        CountDownLatch timeMeasureLatch = new CountDownLatch(1);

        Thread preWorker = new Initializer(prerequisite);
        preWorker.start();
        try {
            prerequisite.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] workers = new WorkerThread[WORKERS_NUM];
        for (int i = 0; i < WORKERS_NUM; i++) {
            workers[i] = new WorkerThread(postRequisite, timeMeasureLatch);
            workers[i].start();
        }

        try {
            StopWatch stopWatch = new StopWatch();

            stopWatch.start();
            timeMeasureLatch.countDown();
            postRequisite.await();
            stopWatch.stop();

            System.out.println(stopWatch.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Latch is finally open!");

        /**
         * 主线程的局部变量对于testVisibility是可见的
         */
        /*Thread testVisibility = new Thread() {
            @Override
            public void run() {
                prerequisite.countDown();
            }
        };*/
    }
}
