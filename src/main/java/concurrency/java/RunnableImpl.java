package concurrency.java;

/**
 * Created by cc on 16/3/5.
 */
public class RunnableImpl implements Runnable {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();

        runnable.run();
    }

    @Override public void run() {
        System.out.println("Hi, I implements Runnable");
    }
}
