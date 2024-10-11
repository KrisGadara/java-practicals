import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiThreadExample {

    public static void main(String[] args) {
        // Shared queue for communication
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // Create and start threads
        Thread generatorThread = new Thread(new NumberGenerator(queue));
        Thread evenProcessorThread = new Thread(new EvenProcessor(queue));
        Thread oddProcessorThread = new Thread(new OddProcessor(queue));

        generatorThread.start();
        evenProcessorThread.start();
        oddProcessorThread.start();
    }

    // Generates random numbers and puts them into the queue
    static class NumberGenerator implements Runnable {
        private final BlockingQueue<Integer> queue;
        private final Random random = new Random();

        public NumberGenerator(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int number = random.nextInt(100); // Generate random number between 0 and 99
                try {
                    queue.put(number);
                    System.out.println("Generated number: " + number);
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    // Processes even numbers from the queue
    static class EvenProcessor implements Runnable {
        private final BlockingQueue<Integer> queue;

        public EvenProcessor(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int number = queue.take();
                    if (number % 2 == 0) {
                        int square = number * number;
                        System.out.println("Even number squared: " + square);
                    } else {
                        // If the number is odd, it should be processed by the OddProcessor
                        queue.put(number);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    // Processes odd numbers from the queue
    static class OddProcessor implements Runnable {
        private final BlockingQueue<Integer> queue;

        public OddProcessor(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int number = queue.take();
                    if (number % 2 != 0) {
                        int cube = number * number * number;
                        System.out.println("Odd number cubed: " + cube);
                    } else {
                        // If the number is even, it should be processed by the EvenProcessor
                        queue.put(number);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
