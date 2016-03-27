package concurrency.java.building;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试hasNext()以及next()中可能抛出的ConcurrentModificationException
 *
 * Created by cc on 16/3/27.
 */
public class ConcurrentModificationExceptionDemo {

    public static final List<String> names =
            Collections.synchronizedList(Lists.<String>newArrayList());

    static {
        names.add("joy");
        names.add("frank");
        names.add("lucy");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Callable<String>() {
            @Override public String call() throws Exception {
                try {
                    for (String name : names) {
                        System.out.println(name);
                    }
                } catch (ConcurrentModificationException e) {
                    System.out.println("oops");
                }

                return "hi, there";
            }
        });

        executorService.submit(new Callable<String>() {
            @Override public String call() throws Exception {
                names.set(0, "pippin");
                names.add("hi");

                return null;
            }
        });
    }
}
