package concurrency.java.building;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试多线程的基类
 *
 * Created by cc on 16/3/27.
 */
public class CommonConcurrentTest {

    protected static final Map<String, Integer> nameAges = new ConcurrentHashMap<>();

    static {
        nameAges.put("joy", 25);
        nameAges.put("frank", 28);
        nameAges.put("lucy", 31);
    }

    protected static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void submitTwoRunnable(Runnable runnable1, Runnable runnable2) {
        executorService.submit(runnable1);
        executorService.submit(runnable2);

        executorService.shutdown();
    }
}
