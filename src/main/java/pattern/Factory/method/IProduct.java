package pattern.factory.method;

/**
 * 工厂类生产的具体产品类需要实现的接口
 *
 * Created by cc on 16/3/6.
 */
public interface IProduct {

    String getName();

    boolean checkGood();

    void use();
}
