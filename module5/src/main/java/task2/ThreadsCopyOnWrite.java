package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadsCopyOnWrite {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> randomNums = new CopyOnWriteArrayList<>();

        Thread threadAdd = new Thread(() -> {
            while (true) {
                    Integer i = new Random().nextInt(10);
                    randomNums.add(i);

                    System.out.println(Thread.currentThread().getName() + " Integer: " + i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread threadSum = new Thread(() -> {
            while (true) {
                    Integer sum = 0;
                    for (Integer i : randomNums) {
                        sum += i;
                    }
                    System.out.println(Thread.currentThread().getName() + " Sum: " + sum);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread threadSquareRoot = new Thread(() -> {
            while (true) {
                    int root = 0;
                    for (Integer i : randomNums) {
                        root += (i * i);
                    }
                    System.out.println(Thread.currentThread().getName() + " Root: " + Math.sqrt(root));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        threadAdd.start();
        threadSum.start();
        threadSquareRoot.start();
    }
}
