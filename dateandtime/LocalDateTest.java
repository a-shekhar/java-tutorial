
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Now: " + today);

        LocalDate myDate = LocalDate.of(2023, 4, 24);
        System.out.println("myDate: " + myDate);

        int dayOfMonth = today.getDayOfMonth();
        Month month = today.getMonth();
        int year = today.getYear();
        int monthValue = today.getMonthValue();

        System.out.println(dayOfMonth);
        System.out.println(month);
        System.out.println(year);
        System.out.println(monthValue);

        LocalDate yesterday = today.minusDays(1);
        System.out.println(yesterday);

        LocalDate findDate1 = today.minusMonths(100);
        System.out.println(findDate1);

        if(today.isBefore(yesterday)){
            System.out.println("Hello");
        } else{
            System.out.println("World");
        }
    }
}
