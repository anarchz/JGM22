package task3;

import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable {
    private final MessageBus queue;
    private AtomicBoolean runFlag = new AtomicBoolean();

    public Consumer(MessageBus queue) {
        this.queue = queue;
        runFlag.set(true);
    }
    
    @Override
    public void run() {
        consume();
    }

    public void consume() {
        while (runFlag.get()) {
            Message message;
            if (queue.isEmpty()) {
                try {
                    queue.waitOnEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!runFlag.get()) {
                System.out.println("Consumer break");
                break;
            }
            message = queue.remove();
            queue.notifyAllForFull();
            useMessage(message);
        }
    }

    public void stop() {
        queue.stopConsume();
        runFlag.set(false);
        queue.notifyAllForEmpty();

    }

    private void useMessage(Message message) {
        if (message.getTopic().equals("1topic")) {
            System.out.println("Message: topic - " + message.getTopic() + "; payload - " + message.getPayload());
        }
    }
}
