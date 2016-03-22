package concurrency.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Future表示一个异步计算任务，当任务完成时可以得到计算结果。如果希望一旦计算完成就拿到结果展示给用户或者做另外的计算，
 * 就必须使用另一个线程不断的查询计算状态。这样做，代码复杂，而且效率低下，因而可以使用Guava提供的注册回调机制
 *
 * 执行Callable逻辑以及处理运算结果(添加监听或回调)都可以通过别的线程池来完成,主线程可继续执行原逻辑
 *
 * Created by cc on 16/3/5.
 */
public class ListeningFutureDemo {

    /**
     * ListeningExecutorService是一个接口
     * 如果使用executorService来注册监听或回调的话则可能会阻塞主线程
     */
    private ListeningExecutorService executorService = MoreExecutors.newDirectExecutorService();

    private ListeningExecutorService anotherExeService = MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(3)
    );

    public static void main(String[] args) {
        ListeningFutureDemo futureDemo = new ListeningFutureDemo();

        futureDemo.testExecutingSequence();

        futureDemo.shutdownExecutor();
    }

    public void shutdownExecutor() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    /**
     * Submit之后线程会立即执行
     * Listener和Callback的执行与Future的get方法无关
     */
    public void testExecutingSequence() {
        Callable<String> callable = new Callable<String>() {
            @Override public String call() throws Exception {
                TimeUnit.SECONDS.sleep(10);

                System.out.println("Execute 5 seconds later");
                return "Hi, there";
            }
        };

        /**
         * 继承自Future接口并添加了addListener方法
         */
        /*ListenableFuture<String> future = executorService.submit(callable);*/
        ListenableFuture<String> future = anotherExeService.submit(callable);

        /**
         * 添加监听或回调函数本质上是一样的
         */
        future.addListener(new Runnable() {
            @Override public void run() {
                System.out.println("Future listener..");
            }
        }, anotherExeService);

        /**
         * 如果省略第三个输入参数,默认使用调用者的Executor
         */
        Futures.addCallback(future, new FutureCallback<String>() {
            @Override public void onSuccess(@Nullable String s) {
                System.out.println("Future callback -- success");
            }

            @Override public void onFailure(Throwable throwable) {
                System.out.println("Future callback -- failed");
                System.out.println(throwable.getMessage());
            }
        }, anotherExeService);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("ExecutionException");
        }
    }
}
