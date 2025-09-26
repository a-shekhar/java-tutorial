
import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime cusTime = LocalTime.of(14, 30, 14);
        System.out.println(cusTime);

        String timeInString = "15:03:59";
        LocalTime parsedTime = LocalTime.parse(timeInString);
        System.out.println(parsedTime);

        LocalTime minusHours = now.minusHours(1);
        System.out.println(minusHours);

        if(now.isAfter(minusHours)){
            System.out.println("hello");
        }
    }
}
