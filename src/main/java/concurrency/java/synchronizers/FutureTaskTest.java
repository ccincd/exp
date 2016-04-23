package concurrency.java.synchronizers;

import java.util.concurrent.*;

/**
 * FutureTask表现上也像一种门闩
 * 使用ExecutorService之后记得要执行shutdown操作
 *
 * Created by cc on 16/4/23.
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 使用Callable和Future获取结果
         */
        Future<Integer> future = executorService.submit(new CalculationDenseCallable());

        /**
         * 使用Callable和FutureTask获取结果
         * executorService.submit(futureTask)后不需要定义变量
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new CalculationDenseCallable());
        executorService.submit(futureTask);

        /**
         * 也可以使用这种方式
         */
        /*Thread taskThread = new Thread(futureTask);
        taskThread.start();*/

        while (!future.isDone()) {
            System.out.println("not done yet, let me sleep one second");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Integer counter = future.get();
            System.out.println(counter + " times to find 9527");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 使用FutureTask获取结果
         */
        try {
            System.out.println(futureTask.get() + " times to find 9527 again");
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
