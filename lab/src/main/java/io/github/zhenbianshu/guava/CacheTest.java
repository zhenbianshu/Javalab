package io.github.zhenbianshu.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zbs 2019/3/18
 */
public class CacheTest {
    public static void main(String[] args) {
        TestedCache testedCache = new TestedCache();
        testedCache.initRuleConfig();
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(testedCache.getUaRules());
        }
    }
}

class TestedCache {

    private LoadingCache<String, String> capacityCache;

    @PostConstruct
    public void initRuleConfig() {

        capacityCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        try {
                            Jedis jedisClient = new Jedis("127.0.0.1", 6379);
                            Set<String> test = jedisClient.smembers(key);
                            test.add("x");
                            try {
                                if (!test.contains("test")) {
                                    throw new Exception("yyyy");
                                }
                            } catch (Exception e) {
                                // todo log
                            }

                            return "aaaaaaaaa";
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                });
    }


    public String getUaRules() {
        try {
            return capacityCache.get("test");
        } catch (Exception e) {
            return "ggggggg";
        }
    }

}

