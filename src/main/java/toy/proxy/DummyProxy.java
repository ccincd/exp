package toy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * DummyProxy
 *
 * @author chi.chen
 * @date 16-2-16
 * @time 下午3:17
 */
public class DummyProxy<T> implements InvocationHandler {

    private List<T> list;

    public DummyProxy(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("hi");
        myList.add("there");
        DummyProxy<String> dummyProxy = new DummyProxy<String>(myList);
        List<String> proxyList = dummyProxy.getProxyInstance();

        try {
            System.out.println(proxyList.size());
            proxyList.add("hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> getProxyInstance() {
        return (List<T>) Proxy.newProxyInstance(DummyProxy.class.getClassLoader(), new Class[] { List.class }, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy test!");

        if ("add".equals(method.getName())) {
            throw new UnsupportedOperationException();
        }
        return method.invoke(list, args);
    }
}
