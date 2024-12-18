package com.xiaobin;

import com.xiaobin.common.Invocation;
import com.xiaobin.protocol.HttpClient;

/**
 * @author Joy
 * @date: 2024/12/18 20:05
 * @description: 消费者
 * Good Luck!!!
 */
public class Consumer {
    public static void main(String[] args) {
//        HelloService helloService;
//        String name = helloService.sayHello("xiaobin");
//        System.out.println(name);

        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"xiaobin"}, "1.0");


        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8888, invocation);
        System.out.println(result);
    }
}
