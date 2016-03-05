package concurrency.java;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 添加监听或回调的时候需要ListenableFuture接口
 * 所以暂时没发现和ListeningFuture结合起来使用的方法
 *
 * Created by cc on 16/3/5.
 */
public class CompletionServiceDemo {

    private static final int PROVIDER_NUMBER = 5;
    private ExecutorService executorService;
    /**
     * 注意此处的泛型
     */
    private CompletionService<String> completionService;

    public CompletionServiceDemo() {
        executorService = Executors.newCachedThreadPool();
        completionService = new ExecutorCompletionService<>(executorService);
    }

    public static void main(String[] args) {
        new CompletionServiceDemo().testProviderConsumer();
    }

    public void testProviderConsumer() {
        /**
         * java不支持泛型数组
         * 可参考: http://blog.csdn.net/orzlzro/article/details/7017435
         */
        for (int i = 0; i < PROVIDER_NUMBER; i++) {
            Callable<String> callable = new Callable<String>() {
                @Override public String call() throws Exception {
                    System.out.println("task is running");
                    TimeUnit.SECONDS.sleep(3);

                    return null;
                }
            };
            completionService.submit(callable);
        }

        executorService.shutdown();

        if (completionService.poll() == null) {
            System.out.println("Right, no return now");
        }

        int counter = PROVIDER_NUMBER;
        while (counter > 0) {
            try {
                Future<String> future = completionService.take();
                System.out.println(future.get());

                counter--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                System.out.println("should not be here");
            }
        }
    }
}
