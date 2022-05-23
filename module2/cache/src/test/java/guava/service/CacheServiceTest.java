package guava.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheServiceTest {
    public CacheService service;

    @Before
    public void setUp() throws Exception {
        service = new CacheService(4);
        service.cache.getUnchecked("first");
        service.cache.getUnchecked("second");
        service.cache.getUnchecked("third");
        service.cache.getUnchecked("forth");
    }

    @Test
    public void whenCacheReachMaxSize_thenEviction(){
        service.cache.getUnchecked("fifth");
        assertEquals(4, service.cache.size());
    }

    @Test
    public void whenTimeExpires_thenEviction() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(0, service.cache.size());
    }
}