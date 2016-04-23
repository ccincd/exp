package concurrency.java.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * 测试门闩
 *
 * Created by cc on 16/4/23.
 */
public class TestLatch {

    private static final Integer WORKERS_NUM = 5;

    public static void main(String[] args) {
        final CountDownLatch prerequisite = new CountDownLatch(1);
        CountDownLatch postRequisite = new CountDownLatch(WORKERS_NUM);

        Thread preWorker = new Initializer(prerequisite);
        preWorker.start();
        try {
            prerequisite.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] workers = new WorkerThread[WORKERS_NUM];
        for (int i = 0; i < WORKERS_NUM; i++) {
            workers[i] = new WorkerThread(postRequisite);
            workers[i].start();
        }

        try {
            postRequisite.await();
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
