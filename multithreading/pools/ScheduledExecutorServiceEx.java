
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx {
    public static void main(String[] args) {
       ScheduledExecutorService schduler = Executors.newScheduledThreadPool(1);
       //schduler.schedule(() -> System.out.println("Task Executed after every 5 seconds"), 5, TimeUnit.SECONDS);
      
        schduler.scheduleAtFixedRate(() -> System.out.println("Task Executed after 5 seconds"), 5, 5, TimeUnit.SECONDS);

        schduler.scheduleWithFixedDelay(() -> System.out.println("Task Executed after 5 seconds"), 5, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = schduler.schedule(() -> {
            System.out.println("Initiating Shutdown...");
            schduler.shutdown();
        }, 20, TimeUnit.SECONDS);
      //  schduler.shutdown();
    }
}
