
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InvokeAll {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = ()
                -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        List<Future<Integer>> futures = new ArrayList<>();
        try {
            futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
        }

        for (Future future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException ex) {
            } catch (ExecutionException ex) {
            }
        }
        executorService.shutdown();

        System.out.println("Hello form java!!!");

    }
}
