package com.xiaobin.common;

/**
 * @author Joy
 * @date: 2024/12/19 20:09
 * @description: URL 路径 获取主机及端口
 * Good Luck!!!
 */
public class URL {
    private String hostname;
    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }


    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
