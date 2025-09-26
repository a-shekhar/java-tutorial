
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeTest {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        ZonedDateTime newyorkTime = ZonedDateTime.of(2001, 12, 12, 14, 8, 31, 0, ZoneId.of("America/Los_Angeles"));
        System.out.println(newyorkTime);

        ZonedDateTime indiaTime = ZonedDateTime.now();
        System.out.println("Time in India: " + indiaTime);
        System.out.println(indiaTime.getZone());

        ZonedDateTime newzelandTime = ZonedDateTime.now(ZoneId.of("NZ"));
        System.out.println("Time in newzeland: " + newzelandTime);
    }
}
