package com.xiaobin.loadbalance;

import com.xiaobin.common.URL;

import java.util.List;
import java.util.Random;

/**
 * @author Joy
 * @date: 2024/12/19 20:21
 * @description: 负载均衡策略
 * Good Luck!!!
 */
public class LoadBalance {


    public static URL random(List<URL> urlList) {
        Random random = new Random();
        int i = random.nextInt(urlList.size());
        return urlList.get(i);
    }

}
