package toy.basic;

/**
 * DerivedPrivateTest
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 上午11:24
 */

public class DerivedPrivateTest extends BaseTest {

    public static void main(String[] args) {
        new DerivedPrivateTest().hi();
    }

    @Override
    protected void hi() {
        super.hi();
        System.out.println("hello");
    }
}
