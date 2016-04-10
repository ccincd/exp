package concurrency.java;

class DerivedWorker implements Runnable {
    @Override public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("hi, there");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 检查子线程未结束时主线程是否结束
 *
 * Created by cc on 16/4/10.
 */
public class ProgramTermination {

    public static void main(String[] args) {
        System.out.println("before");

        new Thread(new DerivedWorker()).start();

        System.out.println("after");
    }
}
