package com.xiaobin.register;

import com.xiaobin.common.URL;

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

    }

    public static List<URL> get(String interfaceName) {
        return map.get(interfaceName);
    }

}
