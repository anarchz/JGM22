package task4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Pool that block when it has not any items or it full
 */
public class BlockingObjectPool {
    private Queue<Object> pool;
    private final Object mutex = new Object();
    private volatile int maxSize;
    /**
     * Creates filled pool of passed size
     * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this.maxSize = size;
        pool  = new LinkedList<>();
    }

    /**
     * Gets object from pool or blocks if pool is empty
     * @return object from pool
     */
    public Object get() throws InterruptedException {
        synchronized (mutex) {
            while (pool.isEmpty()) {
                pool.wait();
            }
            return pool.poll();
        }
    }

    /**
     * Puts object to pool or blocks if pool is full
     * @param object to be taken back to pool
     */
    public void take(Object object) throws InterruptedException {
        synchronized (mutex) {
            while (pool.size() >= maxSize) {
                pool.wait();
            }
            pool.offer(object);
        }
    }
}
