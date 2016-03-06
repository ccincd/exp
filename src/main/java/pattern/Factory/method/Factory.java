package pattern.factory.method;

/**
 * 工厂方法接口,每个具体的工厂类均需要实现该接口
 * 方便横向扩展,但纵向扩展时仍需要修改原代码
 *
 * Created by cc on 16/3/6.
 */
public interface Factory {
    IProduct getProduct();
}
