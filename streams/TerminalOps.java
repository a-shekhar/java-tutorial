package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // collect
        list.stream().skip(1).collect(Collectors.toList());

        list.stream().skip(1).toList();

        // for each
        list.stream().forEach(x -> System.out.println(x));

        // reduce : combines elements to produce a single result 
        Optional<Integer> optionalInt = list.stream().reduce((x, y) -> x + y);

        optionalInt = list.stream().reduce(Integer::sum);

        System.out.println(optionalInt.get());

        // count
        // anyMatch, allMatch, noneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        b = list.stream().allMatch(x -> x % 2 == 0);
        System.out.println(b);

        b = list.stream().noneMatch(x -> x % 2 == 0);
        System.out.println(b);

        // findFirst, findAny
        System.out.println(list.stream().findFirst().get());

        System.out.println(list.stream().findAny().get());

        // Example
        List<String> names = Arrays.asList("Aditya", "Raj", "Ammie");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        System.out.println(numbers.stream().map(x -> x * x).sorted().toList());

        // summing values
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(Integer::sum).get());

        // counting occurrences of a character
        String sentence = "Hello World";
        // char[] charArray = sentence.toCharArray(); -> error
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // stateful vs stateless
        // toArray()
        Object[] array = Stream.of(1, 2, 3).toArray();

        // min max
        System.out.println("max: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));
        System.out.println("max: " + Stream.of(2, 44, 69).max(Comparator.naturalOrder()));

        // forEachOrdered
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with pararell stream: ");
        numbers.parallelStream().forEach(System.out::println);
        System.out.println("Using forEach ordered stream: ");
        numbers.parallelStream().forEachOrdered(System.out::println);

        // input close 
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        List<String> list1 = stream.map(String::toUpperCase).toList();
    
        
    }
}
