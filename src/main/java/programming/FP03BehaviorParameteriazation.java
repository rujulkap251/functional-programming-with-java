package src.main.java.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameteriazation {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);

        filterAndPrint(numbers, x -> x % 2 == 0);

        System.out.println("\n-------\n");

        filterAndPrint(numbers, x -> x % 2 != 0);

        System.out.println("\n-------\n");

        filterAndPrint(numbers, x -> x % 3 == 0);

        System.out.println("\n-------\n");

        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, String> stringOutputFunction = x -> x + " ";

        List<Integer> squaredNukmbers  = mapAndCollect(numbers, squareFunction);

        System.out.println(squaredNukmbers);

        System.out.println("\n-------\n");

        List<Integer> cubedNumbers = mapAndCollect(numbers, x -> x * x * x);

        System.out.println(cubedNumbers);

        System.out.println("\n-------\n");

        List<Integer> doubleNumbers = mapAndCollect(numbers, x -> 2 * x);

        System.out.println(doubleNumbers);

        System.out.println("\n-------\n");

        List<Integer> tripleNumbers = mapAndCollect(numbers, x -> 3 * x);

        System.out.println(tripleNumbers);

    }

    private static List<Integer> mapAndCollect(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
