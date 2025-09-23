package multithreading.thread_creation;

public class Test {
    public static void main(String[] args) {
        // World world = new World();
        // world.start();

        WorldRunnable world2 = new WorldRunnable();
        Thread t1 = new Thread(world2);
        t1.start();

        for(;;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
