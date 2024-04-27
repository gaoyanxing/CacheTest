package org.example;

import org.junit.Test;


public class CacheExampleTest {
    @Test
    //测试HashMap
    public void cacheForHashMapTest(){
        CacheForHashMap.cacheExample();
    }
    @Test
    //测试CurrentHashMap
    public void cacheForCurrentHashMapTest(){
        CacheForCurrentHashMap.cacheForCurrentHashMap();
    }
    @Test
    //测试Caffeine
    public void cacheForCaffeineTest(){
        CacheForCaffeine.cacheForCaffeine();
    }
    //测试Guava
    @Test
    public void cacheForGuavaTest(){
        //Guava 实例创建
        CacheForGuava.cacheForGuava();
        //Guava 被动删除
        CacheForGuava.cacheExpirationExample();
    }
    @Test
    public void cacheForEhcacheTest(){
        CacheForEhcache.cacheForEhcache();
    }
}
