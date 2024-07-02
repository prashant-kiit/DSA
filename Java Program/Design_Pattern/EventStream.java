package Design_Pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Stream
// One by One

public class EventStream {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("App started");

        String[][] messages = {
                { "Vikas", "Hello1" },
                { "Vikas", "Hello2" },
                { "Vikas", "Hello3" },
                { "Vikas", "Hello4" },
                { "Vikas", "Hello5" },
                { "Vikas", "Hello6" },
                { "Prashant", "Nothing1" },
                { "Prashant", "Nothing2" },
                { "Prashant", "Nothing3" },
                { "Prashant", "Nothing4" },
                { "Prashant", "Nothing5" },
                { "Prashant", "Nothing6" },
                { "Subhashish", "Namaste1" },
                { "Subhashish", "Namaste2" },
                { "Subhashish", "Namaste3" },
                { "Subhashish", "Namaste4" },
                { "Velraj", "Good Morning1" },
                { "Velraj", "Good Morning2" }
        };

        Producer producer = new Producer("Ola");

        Consumer consumer1 = new Consumer("Prashant");
        Consumer consumer2 = new Consumer("Vikas");
        Consumer consumer3 = new Consumer("Subhashish");
        Consumer consumer4 = new Consumer("Velraj");

        // use kubernetes to start all docker containers at once or one by one in any
        // order
        consumer1.subscribe(producer);
        consumer2.subscribe(producer);
        consumer3.subscribe(producer);
        consumer4.subscribe(producer);

        Thread.sleep(5000);

        producer.publish(messages, true); // true or false based on temporary or permanent storage of messages;
    }
}

class Producer {
    private String name = null;
    @SuppressWarnings("unused")
    private String[][] messages = null;
    private Map<String, Consumer> registry = new HashMap<>(); // service registry

    public Producer(String name) {
        this.name = name;
    }

    public void register(String name, Consumer consumer) {
        this.registry.put(name, consumer);
    }

    public void publish(String[][] messages, Boolean doStore) throws InterruptedException {
        if (doStore)
            this.messages = messages;
        System.out.println("Producer " + this.name + " publishing");
        // stream and messages are bound together
        Arrays.stream(messages) // Stream of partition(worker)
                // [Collection of such parallelling running workers
                // is cluster]
                .forEach(message -> registry
                        .get(message[0])
                        .getQueue().add(message[1])); // atomic operation //
                                                      // brokering based on topic
                                                      // [message[0]]

    }
}

class Consumer {
    private String name = null;
    private Thread listener = null;
    private volatile Queue<String> queue = new LinkedList<>(); // visibilty // buffer of the stream // stream api

    public Consumer(String name) {
        this.name = name;
    }

    public synchronized Queue<String> getQueue() {
        return this.queue; // atomic operation
    }

    public void subscribe(Producer producer) {
        producer.register(this.name, this); // service registration

        this.listener = new Thread(new Runnable() { // services (services with differnt run time ie. microservices)
            @Override
            public void run() {
                System.out.println("Consumer " + name + " listening to Producer ");
                while (true) {
                    String currentMessage = getQueue().poll(); // atomic operation // stream api
                    // Event driven Architecture
                    if (!(currentMessage == null)) {
                        System.out.println("Message received by " + name);
                        System.out.println(currentMessage);
                        System.out.println("Task performed by " + name);
                    }
                }
            }
        });
        listener.start(); // each running on a docker container
    }

}
