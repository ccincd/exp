package concurrency.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService接口和Execute接口处理异常的不同之处
 *
 * Created by cc on 16/3/6.
 */
public class SubmitAndExecute {

    /**
     * 异常是返回对象的一部分,当get结果时,这个异常会重新被抛出
     */
    public static void testExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override public String call() throws Exception {
                throw new RuntimeException("Oops");

                // return "hi, there";
            }
        });

        try {
            String result = future.get();

            System.out.println("Should not be here" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    public static void testExecutor() {
        Executor executor = new Executor() {
            @Override public void execute(Runnable command) {
                command.run();
            }
        };

        executor.execute(new Runnable() {
            @Override public void run() {
                throw new RuntimeException("Oops");
            }
        });
    }

    public static void main(String[] args) {
        testExecutor();
    }
}
