/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 静态代理表示类在编译阶段就已经存在
 * 这种动态代理方式需要被代理类实现某个接口
 * 没有实现接口的类可以使用CGLib来实现动态代理
 *
 * @author chichen  Date: 16-4-25 Time: 下午3:00
 */
public class WelcomeProxyTest {

    public static void main(String[] args) {
        WelcomeRobot welcomeRobot = new WelcomeRobot();
        InvocationHandler invocationHandler = new WelcomeInvocationHandler(welcomeRobot);

        /**
         * 创建动态代理类
         * 需要被代理类的ClassLoader，Interfaces以及InvocationHandler接口的实现类
         */
        WelcomeInterface proxy = (WelcomeInterface) Proxy.newProxyInstance(
                welcomeRobot.getClass().getClassLoader(),
                welcomeRobot.getClass().getInterfaces(),
                invocationHandler);

        proxy.sayHello();
    }
}
