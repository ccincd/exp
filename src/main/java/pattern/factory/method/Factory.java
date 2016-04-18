package pattern.factory.method;

/**
 * 工厂方法接口,每个具体的工厂类均需要实现该接口
 * 方便横向扩展,但纵向扩展时仍需要修改原代码
 *
 * 工厂模式返回的实例可以不是新创建的，返回由工厂创建好的实例也是可以的
 *
 * Created by cc on 16/3/6.
 */
public interface Factory {
    IProduct getProduct();
}
