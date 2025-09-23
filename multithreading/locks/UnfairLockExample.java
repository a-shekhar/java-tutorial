package multithreading.locks;

public class UnfairLockExample {

    public static void main(String[] args) throws InterruptedException {

        UnfairLock unfairLock = new UnfairLock();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                unfairLock.accessResource();
            }

        };
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread1.sleep(50);
        thread2.start();
        thread1.sleep(50);
        thread3.start();

    }
}
