package multithreading.methods;

public class ThreadPriority extends Thread {

    public ThreadPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 1000000; j++){
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPriority l = new ThreadPriority("Low Priority Thread");
        ThreadPriority m = new ThreadPriority("Medium Priority Thread");
        ThreadPriority h = new ThreadPriority("High Priority Thread");
        l.setPriority(MIN_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        h.setPriority(MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}
