package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Threads {
    public static void main(String[] args) {
        final List<Integer> randomNums = new ArrayList<>();
//        AtomicBoolean addB = new AtomicBoolean(false);
//        AtomicBoolean sumB = new AtomicBoolean(false);
//        AtomicBoolean sqrtB = new AtomicBoolean(false);

        Thread threadAdd = new Thread(() -> {
            while (true) {
                synchronized (randomNums) {
//                    while(sumB.get() && sqrtB.get()) {
//                        try {
//                            randomNums.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                    Integer i = new Random().nextInt(10);
                    randomNums.add(i);

                    System.out.println(Thread.currentThread().getName() + " Integer: " + i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    addB.set(true);
//                    sumB.set(false);
//                    sqrtB.set(false);
                    randomNums.notifyAll();
                }
            }
        });

        Thread threadSum = new Thread(() -> {
            while (true) {
                synchronized (randomNums) {
//                    while (!addB.get()){
//                        try {
//                            randomNums.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
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
//                    sumB.set(true);
                }
            }
        });

        Thread threadSquareRoot = new Thread(() -> {
            while (true) {
                synchronized (randomNums) {
//                    while (!addB.get()){
//                        try {
//                            randomNums.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
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
//                    sqrtB.set(true);
                }
            }
        });

        threadAdd.start();
        threadSum.start();
        threadSquareRoot.start();
    }
}
