package guava.service;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CacheService {
    private Logger logger = Logger.getLogger(CacheService.class.getName());
    private static int capacity;
    public LoadingCache<String, String> cache;

    public CacheService(int capacity) {
        this.capacity = capacity;
        cache = CacheBuilder
                .newBuilder()
                .maximumSize(capacity)
                .expireAfterWrite(500, TimeUnit.MILLISECONDS)
                .removalListener(listener)
                .build(loader);
    }

    CacheLoader<String, String> loader = new CacheLoader<String, String>() {
        @Override
        public String load(String s) throws Exception {
            return s;
        }
    };

    RemovalListener<String, String> listener = new RemovalListener<String, String>() {
        @Override
        public void onRemoval(RemovalNotification<String, String> n){
            if (n.wasEvicted()) {
                String cause = n.getCause().name();
                logger.info(cause);
            }
        }
    };

    public void getStatistic() {
        CacheStats stats = cache.stats();
        System.out.println("Average time spent for putting new values into the cache: " + stats.averageLoadPenalty());
        System.out.println("Number of cache evictions: " + stats.evictionCount());
    }
}
