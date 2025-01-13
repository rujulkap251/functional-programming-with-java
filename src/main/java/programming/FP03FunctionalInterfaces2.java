package src.main.java.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, String> stringOutputFunction = x -> x + " ";

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

        //No input > Return Something
        Supplier<Integer> twoIntegerSupplier = () -> 2;

        Supplier<Integer> twoIntegerSupplier2 = () -> {
            return 2;
        };

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.print(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = x -> 3 * x;

        System.out.print("\n---------\n");

        numbers.stream().map(unaryOperator).forEach(System.out::println);

        System.out.print("\n---------\n");

        System.out.println(unaryOperator.apply(10));

        System.out.print("\n---------\n");

        BiPredicate<Integer, String> biPredicateStringEqualsInteger = (x , y) -> y.equals(x.toString());

        System.out.println(biPredicateStringEqualsInteger.test(3, "3"));

        System.out.println(biPredicateStringEqualsInteger.test(3, "5sd"));

        BiFunction<Integer, String, String> biFunctionIntStringCombination = (x, y) -> x + " in letters is " + y;

        System.out.println(biFunctionIntStringCombination.apply(4, "Four"));

        System.out.println(biFunctionIntStringCombination.apply(5, "Five"));

        BiConsumer<Integer, String> biConsumerIntStringPrint = (x, y) -> System.out.println(x + " " + y);

        biConsumerIntStringPrint.accept(5, "Five");

        //We have int operators as well i.e. for primitives

        IntBinaryOperator findSumOperator = (x, y) -> x + y;

        System.out.println(findSumOperator.applyAsInt(4, 5));

        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction

        //The reason that we prefer the above primitive operators against BinaryOperator<Integer>
        //is because boxing and unboxing (autoboxing) are costly operations and if we are working with only
        //primitives, then using the above operators we can avoid this costly operation.

        //Whenever playing with primitives, we should prefer the primitive operations.

        //The below will not compile becuase it is expecting a parameter
        //Consumer<String> consumer = () -> {}
        //However the below will compile because we are not doing anything with it
        Consumer<String> consumer = (str) -> {};

        //The below will not compile because we are using lambda expression so the compiler will
        //not understand
        //Consumer<String> consumer = (str) -> System.out::println;
        //However, if we don't use lamdba expression, it will compile
        Consumer<String> consumer2 = System.out::println;

        consumer2.accept("abc");


        // This will compile. There is no compulsion to use the 2nd parameter.
        BiConsumer<String, String> biConsumer = (str, str2) -> System.out.println(str);

        Supplier<String> supplier = () -> "abc";

        //The below 2 will not compile because when in curly braces, we need to add return keyword
        //and a semicolon
        //Supplier<String> supplier1 = () -> {"abc"};
        //Supplier<String> supplier2 = () -> {"abc";};
        Supplier<String> supplier3 = () -> {return "abc";};

        //To add multiple statements, we need to have curly braces
        //Hence, the below will not compile
        //BiConsumer<Integer, Integer> biConsumer1 = (str, str2) -> System.out.println(str);System.out.println(str);
        //But tbis will compile
        BiConsumer<Integer, Integer> biConsumer1 = (str, str2) -> {System.out.println(str);System.out.println(str);};

        //We can also provide type for parameters of lambda expression
        Predicate<Integer> myPredicate = (Integer x) -> x % 2 == 0;
        //However, if we provide predicate for one parameter, it is mandatory to provide for the rest
        //Below will not compile
        //BiPredicate<Integer, Integer> myBiPredicate = (Integer x, y) -> x % y == 0;
        //But this will compile
        BiPredicate<Integer, Integer> myBiPredicate = (Integer x, Integer y) -> x % y == 0;

    }
}
