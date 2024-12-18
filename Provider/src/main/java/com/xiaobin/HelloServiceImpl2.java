package com.xiaobin;

/**
 * @author Joy
 * @date: 2024/12/18 20:04
 * @description: 业务实现类
 * Good Luck!!!
 */
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hi" + name;
    }
}
