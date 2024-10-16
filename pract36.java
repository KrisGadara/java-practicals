import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final int MAX_SIZE;
    private Queue<Integer> queue = new LinkedList<>();

    public Buffer(int size) {
        this.MAX_SIZE = size;
    }

    // Method for producer to add an item to the buffer
    public synchronized void produce(int value) throws InterruptedException {
        // Wait until the buffer has space to produce
        while (queue.size() == MAX_SIZE) {
            wait();  // Release the lock and wait for consumer to consume
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        // Notify the consumer that there's something to consume
        notify();
    }

    // Method for consumer to consume an item from the buffer
    public synchronized int consume() throws InterruptedException {
        // Wait until there is something to consume
        while (queue.isEmpty()) {
            wait();  // Release the lock and wait for producer to produce
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        // Notify the producer that there's space to produce more
        notify();
        return value;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                buffer.produce(value++);
                Thread.sleep(500);  // Simulating time to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(1000);  // Simulating time to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class pract36 {
    
    public static void main(String[] args) {
        System.out.println("23DIT012 Kris gadara"); 

        Buffer buffer = new Buffer(5);  // Create a buffer of size 5

        // Create and start producer and consumer threads
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}