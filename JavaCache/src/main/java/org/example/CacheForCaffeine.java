package org.example;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;
//cweeeeeeee好吧
public class CacheForCaffeine {
    public static void cacheForCaffeine(){
        // 创建一个缓存实例，过期时间为5秒
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(1024)
                .build();

        // 向缓存中添加数据
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        // 从缓存中获取数据
        String value1 = cache.getIfPresent("key1");
        String value2 = cache.get("key2", k -> "default");

        // 打印结果
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);

        // 等待5秒后，再次获取数据，此时 key1 的值已经过期
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        value1 = cache.getIfPresent("key1");
        value2 = cache.get("key2", k -> "default");

        // 打印结果
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
    }
}
