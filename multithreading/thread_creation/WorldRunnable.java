package multithreading.thread_creation;

public class WorldRunnable implements Runnable{

    @Override
    public void run() {
        for(;;){
            System.out.println(Thread.currentThread().getName());
        }
    }
    
}
