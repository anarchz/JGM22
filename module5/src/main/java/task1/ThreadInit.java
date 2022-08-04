package task1;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadInit {
    public static void main(String[] args) {
//        Map<Integer, Integer> map1 = Collections.synchronizedMap(new HashMap<>());
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        ThreadSafeMap.SynchronizedMap<Integer, Integer> map = new ThreadSafeMap.SynchronizedMap<>();

        Thread threadAdd = new Thread(() -> {
            Integer key = 0;
            while (true) {
                    map.put(key++, key);
                    System.out.println(Thread.currentThread().getName() + " add " + " " + key);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
            }
        });

        Thread threadSum = new Thread(() -> {
            while (true){
                    Integer sum = 0;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        sum += entry.getValue();
                    }
                    System.out.println(Thread.currentThread().getName() + " sum " + sum);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });


        threadAdd.start();
        threadSum.start();
    }
}
