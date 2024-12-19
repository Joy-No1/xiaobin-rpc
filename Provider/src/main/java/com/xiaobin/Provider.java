package com.xiaobin;

import com.xiaobin.common.URL;
import com.xiaobin.protocol.HttpServer;
import com.xiaobin.register.LocalRegister;
import com.xiaobin.register.RemoteRegisterMap;

/**
 * @author Joy
 * @date: 2024/12/18 20:09
 * @description: 模拟消费者接收网络请求
 * Good Luck!!!
 */
public class Provider {
    public static void main(String[] args) {
        // 接收网络请求 Netty,Tomcat,SocketServer

        LocalRegister.register(HelloService.class.getName(), "1.0", HelloServiceImpl.class);
        LocalRegister.register(HelloService.class.getName(), "2.0", HelloServiceImpl2.class);

        //注册中心注册
        URL url = new URL("localhost", 8888);
        RemoteRegisterMap.register(HelloService.class.getName(), url);

        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }
}
