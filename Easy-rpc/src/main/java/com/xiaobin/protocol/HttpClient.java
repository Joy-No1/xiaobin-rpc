package com.xiaobin.protocol;

import com.xiaobin.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Joy
 * @date: 2024/12/18 20:54
 * @description: Http客户端
 * Good Luck!!!
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {
        //读取用户配置
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();

            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setDoOutput(true);

            OutputStream outputStream = httpUrlConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream = httpUrlConnection.getInputStream();
            return IOUtils.toString(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
