package org.example;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheForEhcache {
    public static void cacheForEhcache(){
        CacheManager cacheManager = CacheManager.create();

        // 获取名为 "myCache" 的 Cache 实例
        Cache cache = cacheManager.getCache("myCache");

        // 向缓存中添加元素
        putValueInCache(cache, "key1", "value1");
        putValueInCache(cache, "key2", "value2");

        // 从缓存中获取元素
        Object value1 = getValueFromCache(cache, "key1");
        Object value2 = getValueFromCache(cache, "key2");
        System.out.println(value1);
        System.out.println(value2);
    }
    private static void putValueInCache(Cache cache, String key, Object value) {
        // 创建 Element 对象
        Element element = new Element(key, value);
        cache.put(element);
    }
    private static Object getValueFromCache(Cache cache, String key) {
        // 从缓存中获取元素
        return cache.get(key).getObjectValue();
    }
}
