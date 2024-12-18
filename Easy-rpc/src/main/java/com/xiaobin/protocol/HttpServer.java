package com.xiaobin.protocol;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Joy
 * @date: 2024/12/18 20:13
 * @description: Http服务器
 * Good Luck!!!
 */
public class HttpServer {

    public void start(String hostname, Integer port) {
        //读取用户配置 server.name=tomcat/netty
        Tomcat tomcat = new Tomcat();

        //服务
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        //连接器
        Connector connector = new Connector();
        connector.setPort(port);


        //引擎
        StandardEngine engine = new StandardEngine();
        engine.setDefaultHost(hostname);

        //主机
        StandardHost host = new StandardHost();
        host.setName(hostname);

        //路径
        String contextPath = "";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

//        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
//        context.addServletMappingDecoded("/*", "dispatcher");


        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
