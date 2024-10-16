class HelloWorldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

public class Prac31 {
    public static void main(String[] args) {
        HelloWorldRunnable r = new HelloWorldRunnable();
        Thread t = new Thread(r);
        t.start();        System.out.println("23DIT012 Kris gadara"); 
    }
}
