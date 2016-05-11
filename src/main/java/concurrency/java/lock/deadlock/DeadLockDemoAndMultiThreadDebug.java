/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package concurrency.java.lock.deadlock;

/**
 * 查询Thread Dump中死锁的步骤
 * 1 打开IDE的命令行
 * 2 执行jps命令找到程序pid
 * 3 执行jstack <pid>命令查看Dump信息
 *
 * @author chichen  Date: 16-3-25 Time: 下午7:22
 */
public class DeadLockDemoAndMultiThreadDebug {

    public static final String hi = "hi";

    public static final String there = "there";

    public static void main(String args[]) {
        Thread thread1 = new Thread(null, new MyThreadOne(hi, there), "Thread-1");
        Thread thread2 = new Thread(null, new MyThreadTwo(hi, there), "Thread-2");
        thread1.start();
        thread2.start();
    }

    static class MyThreadOne implements Runnable {
        private final Object obj1;
        private final Object obj2;

        MyThreadOne(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            System.out.println("Let's try 1");
            synchronized (obj1){
                // add thread breakpoint here
                System.out.println("MyThreadOne Acquired 1st lock");
                synchronized (obj2){
                    System.out.println("MyThreadOne Acquired 2nd lock");
                }
                System.out.println("MyThreadOne Released 2nd lock");
            }
            System.out.println("MyThreadOne Released 1st lock");
        }
    }

    static class MyThreadTwo implements Runnable {
        private final Object obj1;
        private final Object obj2;

        MyThreadTwo(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            System.out.println("Let's try 2");
            synchronized (obj2){
                // add thread breakpoint here
                System.out.println("MyThreadTwo Acquired 2nd lock");
                synchronized (obj1){
                    System.out.println("MyThreadTwo Acquired 1st lock");
                }
                System.out.println("MyThreadTwo Released 1st lock");
            }
            System.out.println("MyThreadTwo Released 2nd lock");
        }
    }
}
