package com.xiaobin.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joy
 * @date: 2024/12/18 20:39
 * @description: 本地注册
 * Good Luck!!!
 */
public class LocalRegister {

    public static Map<String, Class> CLASS_MAP = new HashMap<>();

    public static void register(String interfaceName,String version, Class implClass) {
        CLASS_MAP.put(interfaceName+version, implClass);
    }

    public static Class get(String interfaceName,String version) {
        return CLASS_MAP.get(interfaceName+version);
    }
}
