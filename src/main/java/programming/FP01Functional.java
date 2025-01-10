package src.main.java.programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);
        //printAllNumbersInListFunctional(numbers);
        //printAllNumbersInListFunctional2(numbers);
        //printAllEvenNumbersInListFunctional(numbers);
        //printAllEvenNumbersInListFunctionalWithLambdaExpresion(numbers);
        //printAllOddNumbersInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //printAllCoursesIndividually(courses);
        //filterAndPrintAllCoursesIndividually(courses);
        //printAllCoursesWithAtleast4Letters(courses);
        printNumberOfCharactersInEachCourse(courses);

        //printSquaresOfEvenNumbersInListFunctional(numbers);
        //printCubeOfOddNumbersInListFunctional(numbers);
    }

    private static void printNumberOfCharactersInEachCourse(List<String> courses) {
        courses.stream().map(course -> course + " " + course.length()).forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 != 0).map(number -> number * number * number).forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 0)
                //mapping - x -> x * x
                .map(number -> number * number).forEach(System.out::println);
    }

    private static void printAllCoursesWithAtleast4Letters(List<String> courses) {
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
    }

    private static void filterAndPrintAllCoursesIndividually(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    private static void printAllOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    private static void printAllEvenNumbersInListFunctionalWithLambdaExpresion(List<Integer> numbers) {
        numbers.stream()
                //.filter(FP01Functional::isEven)
                //We can avoid the simple isEven method by writing a Lambda Expression
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(FP01Functional::isEven) //Add a filter - To only allow even numbers
                .forEach(System.out::println);
    }

    private static void printAllNumbersInListFunctional2(List<Integer> numbers) {
        //Here we can replace FP01Functional in the previous method with System.out
        // and print with sysout's println.
        numbers.stream().forEach(System.out::println);
    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //[12,3,4,6,12,3,8,2,9,10,14,12,3]
        //The first thing we need to do is to conver the list of numbers into stream of numbers i.e
        //12
        //3
        //4
        //...numbers...

        numbers.stream().forEach(FP01Functional::print);
    }
}
