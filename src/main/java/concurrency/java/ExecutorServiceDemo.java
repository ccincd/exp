package concurrency.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by cc on 16/3/5.
 */
public class ExecutorServiceDemo {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ExecutorServiceDemo serviceDemo = new ExecutorServiceDemo();

        try {
            // serviceDemo.testFutureCancel();

            // serviceDemo.testGetBlocking();

            // 主线程get超时并不影响子线程继续执行
            // serviceDemo.testGetTimeout();

            serviceDemo.testFutureCancelWithNullResponse();

            System.out.println("In main thread");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is ending");
        serviceDemo.shutDownExecutorService();
    }

    /**
     * 使用完ExecutorService后要及时关闭,不然会影响进程关闭时间(进程会过一段时间再自动关闭)
     */
    public void shutDownExecutorService() {
        executorService.shutdown();
    }

    public void testFutureCancel() throws Exception {
        Future future = executorService.submit(new CallableImpl());

        // TimeUnit.SECONDS.sleep(3);

        boolean isCanceled = future.cancel(true);

        if (isCanceled) {
            System.out.println("Canceled");
        } else {
            System.out.println("Not canceled");
        }

        System.out.println("No hi there from CallableImpl");
    }

    /**
     * If you would like to use a Future for the sake of cancellability but not provide a usable result,
     * you can declare types of the form Future<?> and return null as a result of the underlying task.
     *
     * @throws Exception
     */
    public void testFutureCancelWithNullResponse() throws Exception {
        Future<?> future = executorService.submit(new Callable<Object>() {
            @Override public Object call() throws Exception {
                System.out.println("before cancel");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("after cancel");
                return null;
            }
        });

        future.cancel(true);
        System.out.println("cancelled");
    }

    public void testGetBlocking() throws Exception {
        Future<String> future = executorService.submit(new CallableImpl());

        String hiThere = future.get();
        System.out.println(hiThere);
    }

    public void testGetTimeout() throws Exception {
        Future future = executorService.submit(new CallableImpl());

        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (TimeoutException e) {
            System.out.println("Get timeout...");
        }
    }

    public void testFutureTask() throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new CallableImpl());

        executorService.submit(futureTask);

        System.out.println(futureTask.get());
    }
}
