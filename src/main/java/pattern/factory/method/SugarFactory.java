package pattern.factory.method;

/**
 * Created by cc on 16/3/6.
 */
public class SugarFactory implements Factory {

    @Override public IProduct getProduct() {
        return new Sugar(true, "sweet sugar");
    }
}
