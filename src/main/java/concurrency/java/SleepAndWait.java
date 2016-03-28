package concurrency.java;

/**
 * sleep方法和wait方法的差别
 * sleep是Thread对象的方法，而wait则是Object对象的方法
 * sleep不会释放获取到的锁，而wait方法则会
 *
 * Created by cc on 16/3/28.
 */
public class SleepAndWait {

    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override public void run() {
                synchronized (SleepAndWait.class) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                synchronized (SleepAndWait.class) {
                    System.out.println("this should show 5 seconds later");
                }
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override public void run() {
                synchronized (SleepAndWait.class) {
                    try {
                        Thread.sleep(2000);
                        // 调用某个对象的wait()方法能让当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）
                        SleepAndWait.class.wait();
                        System.out.println("this will show after notify");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        /**
         * 紧接着的两个Thread执行的先后顺序并不能保证
         */
        new Thread(new Runnable() {
            @Override public void run() {
                synchronized (SleepAndWait.class) {
                    System.out.println("this should show 2 seconds later");
                    System.out.println("before notify");
                    SleepAndWait.class.notify();
                }
            }
        }).start();
    }
}
