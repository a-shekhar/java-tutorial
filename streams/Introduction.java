package streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Introduction {

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));

        Predicate<String> wordPrefix = str -> str.toLowerCase().startsWith("ABC");
        System.out.println(wordPrefix.test("ABCz"));
        System.out.println(wordPrefix.test("ABz"));

        // can combine conditions
        wordPrefix.and(wordPrefix);

        // Function -- works for you 
        Function<Integer, Integer> doubleIt = x -> x * 2;
        System.out.println(doubleIt.apply(100));
        Function<Integer, Integer> tripleIt = x -> x * 3;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));

        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));

        // consumer
        Consumer<Integer> print = (x) -> System.out.println(x);
        print.accept(51);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };

        printList.accept(list);

        // supplier
        Supplier<String> giveHelloWorld = () -> "Hello World!!";
        System.out.println(giveHelloWorld.get());

        // combined example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * 2;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate
        // BiConsumer
        // BiFunction
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));

        BiConsumer biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.print(y);
        };
        BiFunction<String, String, Integer> biFunction
                = (x, y) -> x.length() + y.length();
        System.out.println(biFunction.apply("abc", "abc"));
   
        // operators
        UnaryOperator<Integer> a = x -> 2 * x;
        BinaryOperator<Integer> b = (x, y) -> x + y;

        // Method Reference -- use method without invoking in place of lambda function

        List<String> students = Arrays.asList("Aditya", "Raj", "Shekaher");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        // constructor reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone :: new).collect(Collectors.toList());
        System.out.println(mobilePhones);
    }
}

class MobilePhone{
    String name;
    public MobilePhone(String name){
        this.name = name;
    }
}
