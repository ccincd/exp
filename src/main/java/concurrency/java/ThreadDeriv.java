package concurrency.java;

/**
 * Created by cc on 16/3/5.
 */
public class ThreadDeriv extends Thread {

    public static void main(String[] args) {
        ThreadDeriv threadDeriv = new ThreadDeriv();

        threadDeriv.run();
    }

    @Override public void run() {
        System.out.println("Hi, I derived from Thread");
    }
}
