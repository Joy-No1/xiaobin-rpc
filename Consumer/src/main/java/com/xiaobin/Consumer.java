package com.xiaobin;

/**
 * @author Joy
 * @date: 2024/12/18 20:05
 * @description: 消费者
 * Good Luck!!!
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService;
        String name = helloService.sayHello("xiaobin");
        System.out.println(name);
    }
}
