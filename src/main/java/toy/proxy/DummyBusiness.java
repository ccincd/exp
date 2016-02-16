package toy.proxy;

/**
 * DummyBusiness
 *
 * @author chi.chen
 * @date 16-2-16
 * @time 下午5:31
 */
public class DummyBusiness implements DummyInterface {

    private String hi;

    @Override
    public void sayHi() {
        System.out.println("hi DummyBusiness");
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    @Override
    public String toString() {
        return "DummyBusiness{" + "hi='" + hi + '\'' + '}';
    }
}
