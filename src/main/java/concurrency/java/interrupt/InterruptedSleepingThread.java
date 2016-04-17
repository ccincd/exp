package concurrency.java.interrupt;

/**
 * When you catch the InterruptException and swallow it,
 * you essentially prevent any higher level methods/thread groups from noticing the interrupt.
 * Which may cause problems.
 * By calling Thread.currentThread().interrupt(),
 * you set the interrupt flag of the thread,
 * so higher level interrupt handlers will notice it and can handle it appropriately.
 *
 * Created by cc on 16/4/17.
 */
public class InterruptedSleepingThread extends Thread {

    @Override
    public void run() {
        doAPseudoHeavyWeightJob();
    }

    private void doAPseudoHeavyWeightJob() {
        for (int i=0;i<Integer.MAX_VALUE;i++) {
            //You are kidding me
            System.out.println(i + " " + i*2);
            //Let me sleep <evil grin>
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted\n Exiting...");
                break;
            }else {
                sleepBabySleep();
            }
        }
    }

    protected void sleepBabySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            // 如果注释掉Thread.currentThread().isInterrupted()为false 程序会一直执行
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptedSleepingThread thread = new InterruptedSleepingThread();
        thread.start();
        //Giving 10 seconds to finish the job.
        Thread.sleep(10000);
        //Let me interrupt
        thread.interrupt();
    }
}
