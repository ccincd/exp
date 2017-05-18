package concurrency.java.cancellation;

import com.google.common.collect.Lists;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 素数产生器 使用一个flag来标识结束
 * 使用flag的方式在阻塞的场景下可能会无法结束
 *
 * Created by cc on 16/5/4.
 */
public class PrimerGenerator implements Runnable {

    private volatile boolean isCancelled = false;

    private final List<BigInteger> primes = Lists.newArrayList();

    @Override
    public void run() {
        BigInteger finder = BigInteger.ONE;

        while (!isCancelled) {
            // has problem
            // BigInteger nextPrime = finder.nextProbablePrime();
            finder = finder.nextProbablePrime();
            synchronized (this) {
                primes.add(finder);
            }
        }
    }

    public void setCancelled() {
        isCancelled = true;
    }

    public List<BigInteger> getPrimes() {
        return primes;
    }

    public static void main(String[] args) {
        PrimerGenerator primerGenerator = new PrimerGenerator();
        new Thread(primerGenerator).start();

        try {
            TimeUnit.SECONDS.sleep(2);
            // Thread.currentThread().sleep(10 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            primerGenerator.setCancelled();
        }

        /**
         * 设置cancelled标识位之后如果主线程不sleep一段时间
         * 子线程可能在使用primes 而主线程调用get 从而引发冲突
         * 但即便sleep一段时间也不能保证不会发生冲突
         *
         * @throws ConcurrentModificationException
         */
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(primerGenerator.getPrimes());
    }
}
