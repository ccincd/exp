package toy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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

    private DummyInterface dummyInterface;

    public DummyProxy(List<T> list) {
        this.list = list;
    }

    public DummyProxy(DummyInterface dummyInterface) {
        this.dummyInterface = dummyInterface;
    }

    public DummyProxy() {
    }

    public static void main(String[] args) {
        /**
         * 动态代理测试
         */
        /*
         * List<String> myList = new ArrayList<String>(); myList.add("hi"); myList.add("there"); DummyProxy<String>
         * dummyProxy = new DummyProxy<String>(myList); List<String> proxyList = dummyProxy.getListProxyInstance(); try
         * { System.out.println(proxyList.size()); } catch (Exception e) { e.printStackTrace(); }
         */

        DummyProxy anotherProxy = new DummyProxy(new DummyBusiness());
        try {
            DummyInterface anotherInterface = anotherProxy.getDummyInstance();
            anotherInterface.sayHi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * getDeclaredMethod测试
         */
        /*
         * DummyProxy<String> dummyProxy = new DummyProxy<String>(); dummyProxy.invokeHi("chichen", 28);
         */
    }

    public void invokeHi(String name, int age) {
        Method sayHi;
        try {
            sayHi = this.getClass().getDeclaredMethod("hi", String.class, Integer.class);
        } catch (NoSuchMethodException e) {
            sayHi = null;
            e.printStackTrace();
        }

        if (sayHi != null) {
            try {
                sayHi.invoke(this, name, age);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void hi(String name, Integer age) {
        System.out.println("hi, there" + " I'm " + name + ", and I'm " + age + " years old.");
    }

    private void sayHi() {
        System.out.println("Hello, DummyBusiness");
    }

    @SuppressWarnings("unchecked")
    public List<T> getListProxyInstance() {
        return (List<T>) Proxy.newProxyInstance(DummyProxy.class.getClassLoader(), new Class[] { List.class }, this);
    }

    public DummyInterface getDummyInstance() {
        return (DummyInterface) Proxy.newProxyInstance(DummyProxy.class.getClassLoader(),
                new Class[] { DummyInterface.class }, this);
    }

    public int size() {
        System.out.println("this is just a proxy test!");

        return 0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int argLen = 0;
        if (args != null) {
            argLen = args.length;
        }
        Class[] argTypes = new Class[argLen];
        if (args != null) {
            for (int i = 0; i < args.length; ++i) {
                argTypes[i] = args[i].getClass();
            }
        }

        Method declaredMethod;
        try {
            declaredMethod = this.getClass().getDeclaredMethod(method.getName(), argTypes);
            System.out.println(declaredMethod.getName());
        } catch (Exception e) {
            declaredMethod = null;
        }
        if (declaredMethod != null) {
            return declaredMethod.invoke(this, args);
        }

        return method.invoke(list, args);
    }
}
