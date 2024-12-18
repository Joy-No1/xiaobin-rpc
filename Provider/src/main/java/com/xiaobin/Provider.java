package com.xiaobin;

import com.xiaobin.protocol.HttpServer;

/**
 * @author Joy
 * @date: 2024/12/18 20:09
 * @description: 模拟消费者接收网络请求
 * Good Luck!!!
 */
public class Provider {
    public static void main(String[] args) {
        // 接收网络请求 Netty,Tomcat,SocketServer
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8888);
    }
}
