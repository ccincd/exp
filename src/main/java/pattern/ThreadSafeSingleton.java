package pattern;

/**
 * 线程安全的单例类要考虑使用volatile以及锁
 * 锁的粒度可以控制在方法内
 *
 * Created by cc on 16/3/6.
 */
public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton safeSingleton = null;

    private ThreadSafeSingleton() {
        // Empty
    }

    public static ThreadSafeSingleton getInstance() {
        if (safeSingleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (safeSingleton == null) {
                    safeSingleton = new ThreadSafeSingleton();
                }
            }
        }

        return safeSingleton;
    }
}
