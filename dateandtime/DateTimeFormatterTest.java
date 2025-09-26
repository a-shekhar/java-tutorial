
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);


        String date = "25/04/2019";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parse = LocalDate.parse(date, format);
        System.out.println(parse);
    }
}
