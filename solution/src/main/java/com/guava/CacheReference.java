package com.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zbs 2019/4/21
 */
public class CacheReference {
    private LoadingCache<Key, String> capacityCache = CacheBuilder.newBuilder()
            .refreshAfterWrite(1, TimeUnit.MINUTES)
            .softValues()
            .build(new CacheLoader<Key, String>() {
                @Override
                public String load(Key key) {
                    try {
                        System.out.println("loaded");
                        return "aaaaaaaaa";
                    } catch (Exception e) {
                        throw e;
                    }
                }
            });

    public static void main(String[] args) throws Exception {
        CacheReference cacheReference = new CacheReference();
        cacheReference.getCache();
        // System.gc();
        Thread.sleep(3000);
        for (int i = 0; i < 1000; i++) {
            CacheReference cacheReference1 = new CacheReference();
        }
        // capacityCache.invalidateAll();
        cacheReference.getCache();
    }

    public void getCache() throws ExecutionException {
        Key key1 = new Key("111");
        capacityCache.get(key1);
    }

    class Key {
        private String name;

        public Key(String name) {
            this.name = name;
        }
    }
}
