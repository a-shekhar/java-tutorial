package multithreading.methods;

public class ThreadInterrupt extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running.....");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted: " + e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt thread = new ThreadInterrupt();
        thread.start();
        thread.interrupt();
    }
}
