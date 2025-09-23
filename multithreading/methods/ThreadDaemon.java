package multithreading.methods;

public class ThreadDaemon extends Thread {

    @Override
    public void run() {
        while (true) { 
          System.out.println("Hello World!!");   
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDaemon t1 = new ThreadDaemon();
        t1.setDaemon(true);
        
        // ThreadDaemon t2 = new ThreadDaemon();
        // t2.start();
        t1.start();
        System.out.println("Main Done");
    }
}
