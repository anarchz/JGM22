package task3;

public class Consumer implements Runnable {
    private final MessageBus queue;
    private volatile boolean runFlag;

    public Consumer(MessageBus queue) {
        this.queue = queue;
        runFlag = true;
    }
    
    @Override
    public void run() {
        consume();
    }

    public void consume() {
        while (runFlag) {
            Message message;
            if (queue.isEmpty()) {
                try {
                    queue.waitOnEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!runFlag) {
                System.out.println("Consumer break");
                break;
            }
            message = queue.remove();
            queue.notifyAllForFull();
            useMessage(message);
        }
    }

    public void stop() {
        runFlag = false;
        queue.notifyAllForEmpty();
    }

    private void useMessage(Message message) {
        if (message.getTopic().equals("1topic")) {
            System.out.println("Message: topic - " + message.getTopic() + "; payload - " + message.getPayload());
        }
    }
}
