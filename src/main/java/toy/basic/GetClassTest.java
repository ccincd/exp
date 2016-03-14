package toy.basic;

/**
 * GetClassTest
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 下午3:36
 */
public class GetClassTest {

    public static void main(String[] args) {
        new GetClassTest().test();
    }

    /**
     * 返回结果为true，说明使用两种方式均可以 因为getClass是类的非静态成员函数，因为test方法不能为static的
     */
    public void test() {
        boolean flag = GetClassTest.class == getClass();

        System.out.println(flag);
    }
}
