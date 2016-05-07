package concurrency.java.cancellation.hook;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * 添加cancel和静态工厂方法
 *
 * Created by cc on 16/5/6.
 */
public interface CancellableTask<T> extends Callable<T> {

    void cancel();

    RunnableFuture<T> newTask();
}
