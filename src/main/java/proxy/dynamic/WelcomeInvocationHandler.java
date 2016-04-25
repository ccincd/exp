/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用代理类的方法，会转而调用代理类的InvocationHandler实现的invoke方法
 *
 * @author chichen  Date: 16-4-25 Time: 下午2:52
 */
public class WelcomeInvocationHandler implements InvocationHandler {

    private Object concreteClass;

    public WelcomeInvocationHandler(Object concreteClass) {
        this.concreteClass = concreteClass;
    }

    /**
     * 可根据方法名称（如使用正则表达式）或参数类型、个数等来区分不同的处理方式
     *

     public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable {
        Type[] types = method.getParameterTypes();
        if (method.getName().matches("get.+") && (types.length == 1) &&
            (types[0] == String.class)) {
            String key = (String) args[0];
            Object value = cached.get(key);
            if (value == null) {
                value = method.invoke(target, args);
                cached.put(key, value);
            }
            return value;
        }
        return method.invoke(target, args);
     }

     *
     * @param proxy 被代理类
     * @param method 被代理类的方法
     * @param args 被代理类的参数
     * @return 方法执行结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before invocation");

        Object object = method.invoke(concreteClass, args);

        System.out.println("do something after invocation");

        return object;
    }
}
