package task3;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer implements Runnable {
    private final MessageBus queue;
    private AtomicBoolean runFlag = new AtomicBoolean();
    private final Random random;

    public Producer(MessageBus queue) {
        this.queue = queue;
        runFlag.set(true);
        random = new Random();
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        while (runFlag.get()) {
            Message message = generateMessage();
            while (queue.isFull()) {
                try {
                    queue.waitOnFull();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!runFlag.get()) {
                System.out.println("Producer break");
                break;
            }
            queue.add(message);
            queue.notifyAllForEmpty();
        }
    }

    public void stop() {
        while(queue.isStop()) {
            runFlag.set(false);
            queue.notifyAllForFull();
        }
    }


    private Message generateMessage() {
        Integer i = random.nextInt(10);
        Message message = new Message(i + "topic", "payload" + i);
        System.out.println("Generated message: " + message);
        return message;
    }
}
