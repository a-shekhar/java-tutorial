package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        // from list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        long count = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count);

        // from array
        String[] array = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);

        // using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");

        // infinite streams
        Stream<Integer> generate = Stream.generate(() -> 1).limit(100);
        System.out.println(Stream.iterate(0, x -> x + 1).limit(100).collect(Collectors.toList()));

    }
}
