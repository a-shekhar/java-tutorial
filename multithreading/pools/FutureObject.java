package multithreading.pools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureObject {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello from callable";
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        if(future.isDone()){
            System.out.println("Task Done!!!");
        }
        executor.shutdown();
    }
}
