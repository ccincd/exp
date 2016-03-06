package pattern.factory.method;

/**
 * Created by cc on 16/3/6.
 */
public class FishCan implements IProduct {

    private String name;

    private boolean isGood;

    public FishCan(boolean isGood, String name) {
        this.isGood = isGood;
        this.name = name;
    }

    @Override public boolean checkGood() {
        return isGood;
    }

    @Override public void use() {
        System.out.println("eat fish can");
    }

    @Override public String getName() {
        return name;
    }
}
