package guava.service;

import com.google.common.cache.LoadingCache;
import guava.service.CacheService;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CacheService cacheService = new CacheService(5);
        LoadingCache<String, String> cache = cacheService.getCache();
        cache.put("1", "entry1");
        cache.put("2", "entry2");
        cache.put("3", "entry3");
        cache.put("4", "entry4");
        cache.put("5", "entry5");
        cache.put("6", "entry6");
        cache.put("6", "entry6");
        cache.put("6", "entry6");
        cache.put("6", "entry6");
        cache.put("6", "entry6");

        System.out.println(cache);

        cacheService.getStatistic();
    }
}
