package Design_Pattern;

import java.util.LinkedList;
import java.util.Queue;

public class EventBus {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("App started");

        // Events send by sender, received by receivers
        String[] messages = { "Vikas", "Prashant", "Subhashish", "Velraj" };

        // Event sender
        Producer producer = new Producer("Ola");

        // Event receivers
        // Receievers are in sync with sender, but not a among themselves
        Consumer consumer1 = new Consumer("Prashant");
        Consumer consumer2 = new Consumer("Vikas");
        Consumer consumer3 = new Consumer("Subhashish");
        Consumer consumer4 = new Consumer("Velraj");

        consumer1.subscribe(producer);
        consumer2.subscribe(producer);
        consumer3.subscribe(producer);
        consumer4.subscribe(producer);

        Thread.sleep(5000);

        producer.publish(messages);
    }
}

class Producer {
    private String name = null;
    private volatile Queue<String> queue = new LinkedList<>(); // visibilty ensured // message queue

    public Producer(String name) {
        this.name = name;
    }

    public void publish(String[] messages) throws InterruptedException {
        for (String message : messages) {
            Thread.sleep(1000); // Message queues have low throughput, generally
            this.queue.add(message); // atomic operation
        }
        System.out.println("Message published");
    }

    public synchronized String getName() {
        return this.name;
    }

    // concurrency
    public synchronized String getFirstMessageByName(String name) {
        String currentMessage = this.queue.peek(); // atomic operation
        if (name.equals(currentMessage)) {
            return this.queue.poll(); // atomic operation // read and acknowledge requests
        }
        return null;
    }
}

class Consumer {
    private String name = null;
    private Thread listener = null;

    public Consumer(String name) {
        this.name = name;
    }

    public void subscribe(Producer producer) {
        // parallelism
        this.listener = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Consumer " + name + " listening to Producer " + producer.getName());
                while (true) {
                    String currentMessage = producer.getFirstMessageByName(name);
                    if (!(currentMessage == null)) {
                        System.out.println("Message received");
                        System.out.println(currentMessage);
                        System.out.println("Task performed");
                    }
                }
            }
        });
        listener.start();
    }

}
