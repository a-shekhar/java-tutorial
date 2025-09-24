package multithreading.countDown;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       
        int numOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfServices);

        CyclicBarrier barrier = new CyclicBarrier(numOfServices);

        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));

        System.out.println("All dependent services finished. Starting main service.");

        //barrier.reset();
        //barrier.getNumberWaiting();

        executorService.shutdown();
        //executorService.shutdownNow();
    }
}

class DependentService implements Callable<String> {
 
    private CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started.");
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
            barrier.await();
        
        return "Aditya";
    }

}