package concurrency.java.capture;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * 线程安全
 * private constructor capture idiom
 * http://stackoverflow.com/questions/12028925/private-constructor-to-avoid-race-condition
 *
 * Created by cc on 16/3/20.
 */
@ThreadSafe
public class SafePoint {

    @GuardedBy("this") private int x, y;

    /**
     * 目的是为了解决复制构造函数线程安全的问题
     * 但调用其它构造函数应当把调用语句放在第一行
     */
    /*public SafePoint(SafePoint safePoint) {
        int[] xy = safePoint.get();
        // Call to 'this()' must be first statement in constructor body
        // this(xy[0], xy[1]);
    }*/

    public SafePoint cloneSafePoint(SafePoint safePoint) {
        int[] xy = safePoint.get();
        /**
         * 可以使用方法来替代
         */
        return new SafePoint(xy[0], xy[1]);
    }

    /**
     * 构造一个私有方法来过渡
     */
    private SafePoint(int[] xy) {
        this(xy[0], xy[1]);
    }

    /**
     * 所需要的线程安全的复制构造函数
     */
    public SafePoint(SafePoint safePoint) {
        this(safePoint.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[] {x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
