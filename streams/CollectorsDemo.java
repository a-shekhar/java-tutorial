package streams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        // to list
        List<String> names = Arrays.asList("Aditya", "Raj");
        System.out.println(names.stream().collect(Collectors.toList()));

        // to set
        List<Integer> numbers = Arrays.asList(1, 1, 2);
        System.out.println(numbers.stream().collect(Collectors.toSet()));

        // to another collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // joining strings
        String concatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatedNames);

        // summarizing data
        // generate statistical summary (count, min, max, sum, average)
        numbers = Arrays.asList(2, 3, 4, 5, 7);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        // calculating averages 
        Double average = numbers.stream().collect(Collectors.averagingDouble(x -> x));
        System.out.println(average);

        // calculating elements
        Long collect1 = numbers.stream().collect(Collectors.counting());
        System.out.println(collect1);

        // grouping elements
        List<String> words = Arrays.asList("hello", "Hello", "Hi", "Bye", "Ok", "go");
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x.length())));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> collec1 = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collec1);

        // partitioning elements
        // partition elements into 2 groups (true and false) based on predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 2)));

        // mapping and collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        
    }
}
