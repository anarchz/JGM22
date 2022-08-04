package task1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThreadSafeMap {

    public static class SynchronizedMap<K,V> {
        private Map<K,V> map;
        private final Object mutex;

        SynchronizedMap() {
            map = new HashMap<>();
            mutex = this;
        }

        void put(K key, V value) {
            synchronized (mutex) {
                map.put(key, value);
            }
        }

        V get(K key) {
            synchronized (mutex) {
                return map.get(key);
            }
        }

        Set<Map.Entry<K,V>> entrySet() {
            synchronized (mutex) {
                return map.entrySet();
            }
        }
    }

}
