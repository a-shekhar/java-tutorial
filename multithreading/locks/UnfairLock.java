package multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock {

    private final ReentrantLock unfairLock = new ReentrantLock(true);

    public void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            unfairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    }
}
