package org.example;

import java.util.HashMap;
import java.util.Map;

public class CacheForHashMap {
    private Map<String, Object> cache = new HashMap<>();

    public Object getFromCache(String key) {
        return cache.get(key);
    }

    public void putInCache(String key, Object value) {
        cache.put(key, value);
    }
    public static void cacheExample(){
        CacheForHashMap cache=new CacheForHashMap();
        cache.putInCache("key1","value1");
        System.out.println(cache.getFromCache("key1"));
    }
}
