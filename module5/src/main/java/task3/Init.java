package task3;

public class Init {
    public static void main(String[] args) throws InterruptedException {
        MessageBus messageBus = new MessageBus(10);

        Producer producer = new Producer(messageBus);
        Consumer consumer = new Consumer(messageBus);

        Thread produce = new Thread(producer);
        Thread consume = new Thread(consumer);

        produce.start();
        Thread.sleep(100);
        consume.start();

        Thread.sleep(1000);
        consumer.stop();
        producer.stop();

    }
}
