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

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before invocation");

        Object object = method.invoke(concreteClass, args);

        System.out.println("do something after invocation");

        return object;
    }
}
