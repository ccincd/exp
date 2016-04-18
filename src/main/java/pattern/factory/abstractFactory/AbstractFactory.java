package pattern.factory.abstractFactory;

/**
 * 如果要添加一个新的产品族,如小轿车,则需要修改工厂接口以及具体的工厂类
 * 但容易增加一个新的工厂,比如福特的生产线,可以生产商务车,跑车和卡车
 *
 * Created by cc on 16/3/6.
 */
public interface AbstractFactory {

    IBusinessCar getBusinessCar();

    ISportsCar getSportsCar();

    ITruck getTruck();
}
