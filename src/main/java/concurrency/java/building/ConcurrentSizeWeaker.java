package concurrency.java.building;

/**
 * Concurrent类的size和isEmpty函数返回的是一种弱结果
 *
 * Created by cc on 16/3/27.
 */
public class ConcurrentSizeWeaker extends CommonConcurrentTest {

    public static void main(String[] args) {
        submitTwoRunnable(new Runnable() {
            @Override public void run() {
                System.out.println(nameAges.size());
            }
        }, new Runnable() {
            @Override public void run() {
                nameAges.put("leon", 28);
            }
        });
    }
}
