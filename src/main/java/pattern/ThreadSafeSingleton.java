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
            /**
             * 在if判空语句里面添加锁,这样只有在创建的时候才会加锁
             * 如果在方法体处加锁则每次获取对象都会进行锁定,效率较低
             */
            synchronized (ThreadSafeSingleton.class) {
                if (safeSingleton == null) {
                    safeSingleton = new ThreadSafeSingleton();
                }
            }
        }

        return safeSingleton;
    }
}
