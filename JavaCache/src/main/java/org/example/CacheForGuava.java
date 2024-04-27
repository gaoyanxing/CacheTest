package org.example;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheForGuava {
    private static Cache<Integer, String>cache;

    /**
     * 初始化一个GuavaCache
     */
    public static void cacheForGuava(){
         cache = CacheBuilder.newBuilder()
                // 设置 cache 的初始大小为 10，要合理设置该值
                .initialCapacity(10)
                // 设置并发数为 5，即同一时间最多只能有 5 个线程往 cache 执行写入操作
                .concurrencyLevel(5)
                // 设置 cache 中的数据在写入之后的存活时间为 10 秒
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 构建 cache 实例
                .build();
         //添加数据
         cache.put(1,"gyx");
         //获取数据并打印
        String value = cache.getIfPresent(1);
        System.out.println(value);
    }
    /**
     * GuavaCache的被动删除代码
     */
    public static void cacheExpirationExample(){
        cache.put(2,"value2");
        cache.put(3,"value3");
        try {
            //等待10秒
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String value = cache.getIfPresent(2);
        System.out.println(value);
    }
}
