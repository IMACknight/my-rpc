package com.acknight.rpc.proxy;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类获取代理对象
     * 使用Proxy.newProxyInstance方法生成代理对象，这是Java反射API中创建动态代理的标准方式
     * @param serviceClass
     * @return
     * @param <T>
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(), //使用接口的类加载器加载代理类
                new Class[]{serviceClass}, // 代理类实现的接口列表，此处仅为传入的serviceClass
                new ServiceProxy()); // 实现InvocationHandler接口的实例，负责处理方法调用
    }
}
