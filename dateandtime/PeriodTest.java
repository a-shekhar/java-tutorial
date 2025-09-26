
import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate then = LocalDate.of(1990, 2, 2);
        Period period = Period.between(now, then);
        System.out.println(period);

        System.out.println(period.getChronology());
    }
}
