package pattern.factory.method;

/**
 * Created by cc on 16/3/6.
 */
public class FishCanFactory implements Factory {

    @Override public IProduct getProduct() {
        return new FishCan(true, "yummy fish");
    }
}
