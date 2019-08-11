package cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class CustomCache {

    private static final Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    private CustomCache() {}

    public static Integer get(Integer key) {
        return cache.computeIfAbsent(key, CustomCache::compute);
    }


    /**
     * 模拟时间很长的计算操作
     * @param key
     * @return
     */
    private static Integer compute(Integer key) {
        return ThreadLocalRandom.current().nextInt(key);
    }

}
