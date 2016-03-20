package concurrency.java.capture;

import com.google.common.base.Objects;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * 线程不安全
 * 线程安全与否首先要看的是一个类的状态体现在什么地方
 * To understand the solution, you need to understand the problem first.
 *
 * Created by cc on 16/3/20.
 */
@NotThreadSafe
public class UnsafePoint {

    private int x, y;

    public UnsafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] getXY() {
        return new int[] {x, y};
    }

    public synchronized void setXY(int x, int y){
        this.x = x;
        //Simulate some resource intensive work that starts EXACTLY at this point, causing a small delay
        try {
            Thread.sleep(10 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.y = y;
    }

    public String toString(){
        return Objects.toStringHelper(this.getClass()).add("X", x).add("Y", y).toString();
    }

    /**
     * 问题所在，对xy的直接访问会引起竞争条件
     */
    public UnsafePoint(UnsafePoint unsafePoint){
        this(unsafePoint.x, unsafePoint.y);
    }
}
