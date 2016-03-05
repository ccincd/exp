package concurrency.java;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by cc on 16/3/5.
 *
 * Callable<T>中的T表示返回结果类型,与一起使用的Future<T>中的T用法相同
 */
public class CallableImpl implements Callable<String> {

    private long factorial(int n) {
        if (n > 2) {
            return n * factorial(n - 1);
        } else {
            return n;
        }
    }

    @Override public String call() throws Exception {
        long thirtyFac = factorial(35);
        System.out.println("35 factorial is: " + thirtyFac);

        System.out.println("Before sleep");
        TimeUnit.SECONDS.sleep(5);

        System.out.println("Hi there, I implements from callable interface");

        return "Hi there";
    }
}
