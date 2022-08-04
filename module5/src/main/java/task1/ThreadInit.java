package task1;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public class ThreadInit {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Thread threadAdd = new Thread(() -> {
            Integer key = 0;
            while (!Thread.currentThread().isInterrupted()) {
                    map.put(key++, key++);
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
                try {
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
                }catch (ConcurrentModificationException e) {
                    e.printStackTrace();
                    threadAdd.interrupt();
                    break;
                }

            }
        });


        threadAdd.start();
        threadSum.start();
    }
}
