
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime customDate = LocalDateTime.of(2025, 4, 25, 20, 15, 30);
        System.out.println(customDate);
    
        System.out.println(LocalDateTime.parse("2025-01-11T13:49"));
        
    }
}
