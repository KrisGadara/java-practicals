public class prac35 {
    public static void main(String[] args) {
        System.out.println("23DIT012-Kris gadara"); 
        Thread firstThread = new Thread(() -> {
            System.out.println("FIRST thread is running.");
        }, "FIRST");

        Thread secondThread = new Thread(() -> {
            System.out.println("SECOND thread is running.");
        }, "SECOND");

        Thread thirdThread = new Thread(() -> {
            System.out.println("THIRD thread is running.");
        }, "THIRD");

        firstThread.setPriority(3);
        secondThread.setPriority(Thread.NORM_PRIORITY); // default priority is 5
        thirdThread.setPriority(7);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        
        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
