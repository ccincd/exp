package pattern.factory;

import org.apache.commons.lang3.StringUtils;

/**
 * 简单工厂,使用静态方法,通过接收参数的不同来返回不同的对象
 * 需求有变动的话,不修改原代码是无法完成扩展的
 *
 * 可以将Product作为一个抽象类或接口
 *
 * Created by cc on 16/3/6.
 */
public class SimpleFactory {

    public static Product getProduct(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        if (name.equals("Cookie")) {
            return new Product(name, "1425", 260);
        } else if (name.equals("Fanta")) {
            return new Product(name, "1426", 600);
        } else {
            throw new UnsupportedOperationException("no such product");
        }
    }
}
