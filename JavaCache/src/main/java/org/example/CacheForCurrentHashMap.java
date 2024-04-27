package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class CacheForCurrentHashMap {
    public static void cacheForCurrentHashMap(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        // 多个线程同时操作 ConcurrentHashMap
        new Thread(() -> {
            map.put("key1", "value1");
        }).start();

        new Thread(() -> {
            String value = map.get("key1");
            System.out.println("Value: " + value);
        }).start();
    }
}
