import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationTest {
    public static void main(String[] args) {
        Instant start = Instant.now();
        Instant end = Instant.now();
        Duration d1 = Duration.between(start, end);
       
       Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
       System.out.println(d1);
       System.out.println(d2);

       int i = d1.compareTo(d2);
       System.out.println(i);

    }
}
