package com.xiaobin;


import com.xiaobin.proxy.ProxyFactory;

/**
 * @author Joy
 * @date: 2024/12/18 20:05
 * @description: 消费者
 * Good Luck!!!
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService= ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("xiaobin");
        System.out.println(result);
    }
}
