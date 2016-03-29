/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package concurrency.java;

/**
 * @author chichen  Date: 16-3-29 Time: 下午1:57
 */
public class JoinAndYield {

    public static void main(String[] args) {
        final Thread threadOne = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    /**
                     * 当前线程暂停，进入就绪状态，让系统的线程调度器重新调度一次
                     * 测试无意义
                     */
                    Thread.yield();
                    /**
                     * 睡眠3秒后回到可执行状态，未必是立即执行
                     */
                    Thread.sleep(3000);
                    System.out.println("after sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*Thread threadTwo = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("before join..");
                try {
                    threadOne.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3 seconds later");
            }
        });*/

        Thread threadThree = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("before yield..");
                // 通过对象调用了静态方法
                // threadOne.yield();
                System.out.println("immediately after yielding");
            }
        });

        threadOne.start();
        // threadTwo.start();
        threadThree.start();
    }
}
