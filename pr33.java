import java.util.Random;

// Thread to generate random numbers
class RandomNumberGenerator extends Thread {
    private final SharedData sharedData;

    public RandomNumberGenerator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(100);  // Generate random number between 0 and 99
            sharedData.setNumber(number);      // Set the number in shared data
            System.out.println("Generated number: " + number);
            
            // Sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // Restore interrupt status
                break;
            }
        }
    }
}

// Thread to calculate the square of even numbers
class SquareCalculator extends Thread {
    private final SharedData sharedData;

    public SquareCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            if (sharedData.isEven()) {  // Check if the number is even
                int number = sharedData.getNumber();
                System.out.println("Square of " + number + " is: " + (number * number));
            }
        }
    }
}

// Thread to calculate the cube of odd numbers
class CubeCalculator extends Thread {
    private final SharedData sharedData;

    public CubeCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            if (sharedData.isOdd()) {  // Check if the number is odd
                int number = sharedData.getNumber();
                System.out.println("Cube of " + number + " is: " + (number * number * number));
            }
        }
    }
}

// Shared data class for communication between threads
class SharedData {
    private int number;  // The shared number
    private boolean even; // Indicates if the number is even

    // Synchronized method to set the number and notify all waiting threads
    public synchronized void setNumber(int number) {
        this.number = number;
        this.even = (number % 2 == 0);
        notifyAll();  // Notify all waiting threads that the number has been updated
    }

    // Synchronized method to get the number
    public synchronized int getNumber() {
        return number;
    }

    // Synchronized method to check if the number is even
    public synchronized boolean isEven() {
        return even;
    }

    // Synchronized method to check if the number is odd
    public synchronized boolean isOdd() {
        return !even;
    }
}

// Main class
public class pr33 {
    public static void main(String[] args) {
        System.out.println("23DIT012 Kris gadara");
        System.out.println("--------------------");

        SharedData sharedData = new SharedData();  // Shared data instance

        // Create thread instances
        RandomNumberGenerator generator = new RandomNumberGenerator(sharedData);
        SquareCalculator squareCalculator = new SquareCalculator(sharedData);
        CubeCalculator cubeCalculator = new CubeCalculator(sharedData);

        // Start the threads
        generator.start();
        squareCalculator.start();
        cubeCalculator.start();
    }
}
