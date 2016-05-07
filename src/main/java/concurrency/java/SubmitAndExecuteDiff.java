package concurrency.java;

import java.util.concurrent.*;

/**
 * submit和execute在处理异常上的差别
 * execute没有返回值 submit有
 *
 * Created by cc on 16/5/7.
 */
public class SubmitAndExecuteDiff {

    static class MadException extends RuntimeException {
        public MadException(String message) {
            super(message);
        }
    }

    static class ThrowExceptionTask implements Runnable {
        @Override public void run() {
            System.out.println("hi, there, I'm going to be mad");

            throw new MadException("oops");
        }
    }

    /**
     * UncaughtExceptionHandler是一个接口
     */
    static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + " produced an exception!");
            System.out.println("exception info: " + e.getMessage());
        }
    }

    static class HandlerThreadFactory implements ThreadFactory {
        @Override public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

            return thread;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * a Throwable generated by a task queued with submit() will bind the Throwable
         * to the Future that was produced from the call to submit().
         * Calling get() on that Future will throw an ExecutionException with the original Throwable as its cause
         */
        Future future = executorService.submit(new ThrowExceptionTask());
        try {
            TimeUnit.SECONDS.sleep(3);
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
            e.printStackTrace();
        }

        /**
         * A task queued with execute() that generates some Throwable will cause the UncaughtExceptionHandler
         * for the Thread running the task to be invoked. The default UncaughtExceptionHandler,
         * which typically prints the Throwable stack trace to System.err,
         * will be invoked if no custom handler has been installed.
         */
        // executorService.execute(new ThrowExceptionTask());

        ExecutorService handledExecutorService = Executors.newSingleThreadExecutor(new HandlerThreadFactory());
        handledExecutorService.execute(new ThrowExceptionTask());
    }
}
