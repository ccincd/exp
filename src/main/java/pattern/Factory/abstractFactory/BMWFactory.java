package pattern.factory.abstractFactory;

/**
 * Created by cc on 16/3/6.
 */
public class BMWFactory implements AbstractFactory {

    @Override public IBusinessCar getBusinessCar() {
        return null;
    }

    @Override public ITruck getTruck() {
        return null;
    }

    @Override public ISportsCar getSportsCar() {
        return null;
    }
}
