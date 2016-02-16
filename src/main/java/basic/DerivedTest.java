package basic;

/**
 * DerivedTest
 *
 * @author chi.chen
 * @date 16-2-15
 * @time 下午5:25
 */
public class DerivedTest extends BaseTest {
    private int counter;

    public DerivedTest(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        BaseTest baseTest = new DerivedTest(5);
        baseTest.hi();
    }

    /* 方法也可以用final来修饰，不可被重写 */
    /*
     * public void hello() { System.out.println("hi, derived"); }
     */

    @Override
    public void hi() {
        System.out.println("hello");
        System.out.println("counter: " + counter);
    }
}
