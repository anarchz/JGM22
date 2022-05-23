package simpleJava.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheServiceTest {
    public CacheService service;

    @Before
    public void setUp() throws Exception {
        service = new CacheService(4);
        service.put(1,"first");
        service.put(2,"second");
        service.put(3,"third");
        service.put(4,"forth");
    }


    @Test
    public void whenCacheReachMaxSize_thenEviction() {
        service.put(5,"fifth");
        assertEquals(4, service.getSize());
    }

    @Test
    public void whenTimeExpires_thenEviction() throws InterruptedException {
        Thread.sleep(600);
        service.cleanerThread.stop();
        assertEquals(0, service.getSize());
    }
}