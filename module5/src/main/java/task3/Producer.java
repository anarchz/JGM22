package task3;

import java.util.Random;

public class Producer implements Runnable {
    private final MessageBus queue;
    private volatile boolean runFlag;
    private final Random random;

    public Producer(MessageBus queue) {
        this.queue = queue;
        runFlag = true;
        random = new Random();
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        while (runFlag) {
            Message message = generateMessage();
            while (queue.isFull()) {
                try {
                    queue.waitOnFull();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!runFlag) {
                System.out.println("Producer break");
                break;
            }
            queue.add(message);
            queue.notifyAllForEmpty();
        }
    }

    public void stop() {
        runFlag = false;
        queue.notifyAllForFull();
    }


    private Message generateMessage() {
        Integer i = random.nextInt(10);
        Message message = new Message(i + "topic", "payload" + i);
        System.out.println("Generated message: " + message);
        return message;
    }
}
