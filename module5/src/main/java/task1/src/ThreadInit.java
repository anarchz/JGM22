import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadInit {
    public static void main(String[] args) throws InterruptedException {
//        Map<Integer, Integer> map1 = Collections.synchronizedMap(new HashMap<>());
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        long startTime = System.nanoTime();
        final AtomicBoolean end = new AtomicBoolean(true);
        final ThreadSafeMap.SynchronizedMap<Integer, Integer> map = new ThreadSafeMap.SynchronizedMap<Integer,Integer>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer key = 0;
                while (end.get()) {
                    map.put(key++, key);
                    System.out.println(Thread.currentThread().getName() + " add " + " " + key);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        Thread threadAdd = new Thread(runnable);


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (end.get()){
                    Integer sum = 0;
                    synchronized (map) {
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            sum += entry.getValue();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " sum " + sum);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread threadSum = new Thread(runnable1);


        threadAdd.start();
        threadSum.start();

        for(int t = 1; t < 1000; t++) {
            new Thread(runnable).start();
            new Thread(runnable1).start();
        }

        Thread.sleep(2000);
        end.set(false);
        Thread.sleep(500);
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }

//    2 threads
//    java11 - 2520363600 nanoseconds
//             2533041300
//             2526978300
//    java8 -  2521926900
//             2519367400
//             2518948700
//    java6 -  2522761000
//             2507318300
//             2531419900

    //    1000 threads
//    java11 - 3446404400 nanoseconds

//    java8 -  3191585300

//    java6 -  3212323200

}
