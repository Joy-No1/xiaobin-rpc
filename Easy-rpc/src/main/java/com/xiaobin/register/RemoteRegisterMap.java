package com.xiaobin.register;

import com.xiaobin.common.URL;

import java.io.*;
import java.util.*;

/**
 * @author Joy
 * @date: 2024/12/19 20:10
 * @description: 注册中心
 * Good Luck!!!
 */
public class RemoteRegisterMap {


    public static Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = map.get(interfaceName);
        list = list == null ? new ArrayList<>() : list;
        list.add(url);
        map.put(interfaceName, list);
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        map = getFile();
        return map.get(interfaceName);
    }

    private static void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("/Users/joy/IdeaProjects/xiaobin-rpc/Easy-rpc/temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fis = new FileInputStream("/Users/joy/IdeaProjects/xiaobin-rpc/Easy-rpc/temp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Map<String, List<URL>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
