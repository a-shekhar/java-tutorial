
import java.time.Instant;

public class InstantTest {
    public static void main(String[] args) {
        long currTimeMillis = System.currentTimeMillis();
        System.out.println(currTimeMillis);
        Instant now = Instant.now();
        System.out.println(now);
    }
}
