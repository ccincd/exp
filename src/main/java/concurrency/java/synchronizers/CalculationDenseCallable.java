package concurrency.java.synchronizers;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 一个实现Callable接口的繁重计算任务
 * 注意泛型的书写方式
 *
 * Created by cc on 16/4/23.
 */
public class CalculationDenseCallable implements Callable<Integer> {

    private static final int MAX_RANGE = 10000000;

    private boolean isBadCase;

    public CalculationDenseCallable(boolean isBadCase) {
        this.isBadCase = isBadCase;
    }

    @Override
    public Integer call() throws Exception {
        if (isBadCase) {
            throw new MyCheckedException();
        }

        int counter = 0;
        Random random = new Random();
        while (random.nextInt(MAX_RANGE) != 9527) {
            counter++;
        }

        return counter;
    }
}
