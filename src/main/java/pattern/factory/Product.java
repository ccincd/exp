package pattern.factory;

/**
 * Created by cc on 16/3/6.
 */
public class Product {

    private String name;

    private String serialNumber;

    private float weight;

    public Product(String name, String serialNumber, float weight) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.weight = weight;
    }
}
