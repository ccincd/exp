package basic;

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
    public BaseTest() {
        hi();
    }

    protected void hi() {
        System.out.println("hi");
    }

    /*
     * public final void hello() { System.out.println("hello"); }
     */
}
