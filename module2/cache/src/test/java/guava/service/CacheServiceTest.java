package guava.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheServiceTest {
    public CacheService service;

    @Before
    public void setUp() throws Exception {
        service = new CacheService(4);
        service.getCache().getUnchecked("first");
        service.getCache().getUnchecked("second");
        service.getCache().getUnchecked("third");
        service.getCache().getUnchecked("forth");
    }

    @Test
    public void whenCacheReachMaxSize_thenEviction(){
        service.getCache().getUnchecked("fifth");
        assertEquals(4, service.getCache().size());
    }

    @Test
    public void whenTimeExpires_thenEviction() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(0, service.getCache().size());
    }
}