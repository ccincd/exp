package toy.basic;

import java.text.DecimalFormat;

/**
 * BaseTest
 *
 * @author chi.chen
 * @date 16-2-15
 * @time 下午5:24
 */
public class BaseTest {
    /**
     * 构造器绝不能调用可被覆盖的方法
     */
    /*
     * public BaseTest() { hi(); }
     */

    private void sayHello() {
        System.out.println("hi");
    }

    protected void hi() {
        sayHello();
    }

    /*
     * public final void hello() { System.out.println("hello"); }
     */

    public static String formatPrice(float price) {
        /*DecimalFormat decimalFormat = new DecimalFormat("＃.00");
        return decimalFormat.format();*/

        return String.format("%.2f", price / 10000);
    }

    public static void main(String[] args) {
        float f = 10f;

        System.out.println(formatPrice(f));
    }
}
