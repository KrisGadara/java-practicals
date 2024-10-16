public class prac34 {
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println("23DIT012 kris gadara");         
        Thread incrementThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println("Counter value after incrementing: " + counter);
        });

        incrementThread.start();
        try {
            incrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
