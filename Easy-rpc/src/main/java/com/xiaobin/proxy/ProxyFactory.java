package com.xiaobin.proxy;

import com.xiaobin.common.Invocation;
import com.xiaobin.common.URL;
import com.xiaobin.loadbalance.LoadBalance;
import com.xiaobin.protocol.HttpClient;
import com.xiaobin.register.RemoteRegisterMap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author Joy
 * @date: 2024/12/19 19:57
 * @description: 代理工厂
 * Good Luck!!!
 */
public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass) {
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args, "1.0");
                HttpClient httpClient = new HttpClient();

                //服务发现
                List<URL> urlList = RemoteRegisterMap.get(interfaceClass.getName());

                //负载均衡
                URL url = LoadBalance.random(urlList);
                return httpClient.send(url.getHostname(), url.getPort(), invocation);
            }
        });
        return (T) proxyInstance;
    }
}
