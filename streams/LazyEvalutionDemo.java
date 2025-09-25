package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvalutionDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aditya", "Raj", "Shekhar");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 3;
                });

        System.out.println("Before Terminal Operation");

        List<String> result = stream.toList();

        System.out.println("After Terminal Operation");

        System.out.println(result);

    }
}
