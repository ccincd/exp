package concurrency.java.building;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程安全的List锁对象的粒度
 *
 * Created by cc on 16/3/27.
 */
public class AddDeleteInterleaving {

    private static List<String> content = Lists.newArrayList();

    public static final List<String> names = Collections.synchronizedList(content);

    static {
        names.add("joy");
        names.add("bob");
        names.add("lucy");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // get
        executorService.submit(new Runnable() {
            @Override public void run() {
                try {
                    synchronized (names) {
                        System.out.println("thread one");
                        int lastIndex = names.size() - 1;
                        System.out.println("thread one lastIndex: " + lastIndex);
                        System.out.println(names.get(lastIndex));
                    }
                } catch (Exception e) {
                    System.out.println("oops");
                }
            }
        });

        // delete
        executorService.submit(new Runnable() {
            @Override public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (names) {
                    System.out.println("thread two");
                    int lastIndex = names.size() - 1;
                    System.out.println("thread two lastIndex: " + lastIndex);
                    names.remove(lastIndex);
                    System.out.println("removed last element");
                    System.out.println("after removing: " + names);
                }
            }
        });

        System.out.println("main thread");

        executorService.shutdown();
    }
}
