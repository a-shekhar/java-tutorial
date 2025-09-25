package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // transforms one stream to another stream
        // by default lazy
        List<String> list = Arrays.asList("Aditya", "Adi", "Raj", "Shekhar");
        
        // filter
        Stream<String> a = list.stream().filter(x -> x.startsWith("A"));
        System.out.println(a.collect(Collectors.toList()));
    
        // map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // sorted
        Stream<String> sortedStream = list.stream().sorted();

        Stream<String> sortedStreamUsingComparator = list.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // distinct 
        list.stream().filter(x -> x.startsWith("A")).distinct();
    
       // limit
       System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

       // skip
       System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());
       
       // peek
       // peforms an action on each element as it is consumed
       Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();
    
       // flatMap
       List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("Mango", "grape")
        );

        System.out.println(listOfLists.get(1).get(1));
        
        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());


        List<String> sentences = Arrays.asList(
            "Hello World",
            "Java Streams are powerful",
            "Java is beautiful"
        );

        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).toList());
    
    
    }
}

