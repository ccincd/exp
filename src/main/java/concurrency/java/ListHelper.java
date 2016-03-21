package concurrency.java;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 线程不安全，注意锁对象
 *
 * @see ImprovedList
 * Created by cc on 16/3/20.
 */
@NotThreadSafe
public class ListHelper<T> {

    public List<T> list = Collections.synchronizedList(new ArrayList<T>());

    /**
     * synchronized关键字的锁对象是ListHelper，与Wrapper即被代理的Client没有关系
     * 锁对象不一致会引发问题
     */
    public synchronized boolean putIfAbsent(T x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }

        return absent;
    }

    /**
     * 应当使用这种加锁方式
     * In order to use client-side locking, you must know what lock X uses
     */
    /*public boolean putIfAbsent(T x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }

            return absent;
        }
    }*/
}
