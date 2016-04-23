package concurrency.java.synchronizers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 信号量测试类
 * 信号量与Latch不同 可退化成Mutex
 * 可使用信号量来实现一个线程池或者连接池或者对象池
 * "A binary semaphore can be used as a mutex with non-reentrant locking semantics"
 *
 * Created by cc on 16/4/23.
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;// 就算此处是return finally同样会执行
        } finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }
}
