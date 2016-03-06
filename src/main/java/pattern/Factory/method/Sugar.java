package pattern.factory.method;

/**
 * Created by cc on 16/3/6.
 */
public class Sugar implements IProduct {

    private String name;

    private boolean isGood;

    public Sugar(boolean isGood, String name) {
        this.isGood = isGood;
        this.name = name;
    }

    @Override public boolean checkGood() {
        return isGood;
    }

    @Override public String getName() {
        return name;
    }

    @Override public void use() {
        System.out.println("use sugar");
    }
}
