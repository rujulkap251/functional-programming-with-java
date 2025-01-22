package src.main.java.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05CreatingStreamsWithArrays {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //This is one way of creating streams
        numbers.stream();

        //Another way
        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count());

        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum));

        //Whenever we create a stream of integers this way, it basically creates a stream like this
        //List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
        //The stream of integers get auto boxed to the Integer class
        //The disadvantage with this approach is that when we perform operations like sum on them
        //the integers are unboxed and then again autoboxed, resulting in a costly operation
        Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //Hence, we should also be able to simply create a list of primitive integers
        //One way is to create stream from an array
        int[] intArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        //Can also create a stream from arrays
        System.out.println(Arrays.stream(intArray).sum());
        System.out.println(Arrays.stream(intArray).max());
        System.out.println(Arrays.stream(intArray).min());
        System.out.println(Arrays.stream(intArray).average());

        //We can also create stream of primitive ints using InStream
        System.out.println(IntStream.range(1, 10).sum()); //45 - range exclusive
        System.out.println(IntStream.rangeClosed(1, 10).sum()); //55 - range inclusive

        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum());
        System.out.println(IntStream.iterate(0, e -> e + 2).limit(10).peek(System.out::println).sum());
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());

        //We cannot simply collect IntStream to list, like below
        //IntStream.iterate(2, e -> e * 2).limit(10).collect(Collectors.toList());
        //Before we apploy collect and convert it to List, we need to perform a boxed operation to convert
        //primitive int to Integer class
        System.out.println(
                IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList())
        );

        //Just like IntStream, there are DoubleStream, LongStream to create streams of Int, Double, and Long

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        //The result is coming up as 0 because we have IntStream
        System.out.println(IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
        //In these cases, where the limit exceeds, we can use LongStream
        System.out.println(LongStream.rangeClosed(1, 50).reduce(1L, (x, y) -> x * y));
        //However, as we see the range still exceeds and returning negative value
        //So, we can use BigInteger here
        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (x, y) -> x.multiply(y)));
        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
