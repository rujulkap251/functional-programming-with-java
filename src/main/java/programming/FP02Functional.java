package src.main.java.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);
        List<Integer> newNumbers = List.of(12, 3, 4, 6);
        List<Integer> newNumbers2 = List.of(-12, -3, -4, -6);
        //int sum  = addListFunctional(numbers);
        //int mul  = multiplyListFunctional(newNumbers);
        //int sum  = addListFunctionalExperiment(numbers);
        //int sum  = addListFunctionalExperiment2(numbers);
        //int highest  = findHighestInListFunctional(numbers);
        //int highest  = findHighestInListFunctional2(newNumbers2);
        //int minimun  = findLowestInListFunctional(numbers);
        //int sum = findSumOfSquaresOfNumbersInList(numbers);
        //int sum = findSumOfCubesOfNumbersInList(numbers);
        //int sum = findSumOfOddNumbersInList(numbers);
        //int sum = findSumOfEvenNumbersInList(numbers);
        //System.out.println(sum);
        //printDistinctNumbersInList(numbers);
        //printSortedNumbersInList(numbers);
        //printDistinctSortedNumbersInList(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //printDistinctSortedCoursesInList(courses);
        //printDistinctSortedCoursesInList2(courses);
        //printDistinctReverselySortedCoursesInList(courses);
        //printDistinctSortedCoursesInListSortedBasedOnLengthOfCourse(courses);
        //printDistinctSortedNumbersInListSortedBasedOnLengthOfNumbers(numbers);

        //List<Integer> doubledNumbers = doubleNumber(numbers);
        //List<Integer> evenNumbers = getEvenNumbers(numbers);
        List<Integer> lengthOfCourses = getLengthOfCourses(courses);
        System.out.println(lengthOfCourses);

    }

    private static List<Integer> getLengthOfCourses(List<String> courses) {
        return courses.stream().map(x -> x.length()).collect(Collectors.toList());
    }

    private static List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());
    }

    private static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
    }

    private static void printDistinctSortedNumbersInListSortedBasedOnLengthOfNumbers(List<Integer> numbers) {
        numbers.stream().distinct().sorted(Comparator.comparing(x -> x.toString().length())).forEach(System.out::println);
    }

    /**
     * This method prints distinct courses based on the length of the course
     * This method defines its own comparator to compare the courses based on the length of
     * string.
     * @param courses
     */
    private static void printDistinctSortedCoursesInListSortedBasedOnLengthOfCourse(List<String> courses) {
        courses.stream().distinct().sorted(Comparator.comparing(x -> x.length())).forEach(System.out::println);
    }

    private static void printDistinctReverselySortedCoursesInList(List<String> courses) {
        courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void printDistinctSortedCoursesInList2(List<String> courses) {
        courses.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void printDistinctSortedCoursesInList(List<String> courses) {
        courses.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void printDistinctSortedNumbersInList(List<Integer> numbers) {
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void printSortedNumbersInList(List<Integer> numbers) {
        numbers.stream().sorted().forEach(System.out::println);
    }

    private static void printDistinctNumbersInList(List<Integer> numbers) {
         numbers.stream().distinct().forEach(System.out::println);
    }

    private static int findSumOfEvenNumbersInList(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
    }

    private static int findSumOfOddNumbersInList(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
    }

    private static int findSumOfCubesOfNumbersInList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
    }

    private static int findSumOfSquaresOfNumbersInList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
    }

    private static int findLowestInListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y?y:x);
    }

    /**
     * Solution to find the highest no matter if the list contains all negative numbers
     * @param numbers
     * @return
     */
    private static int findHighestInListFunctional2(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x:y);
    }

    /**
     * This logic will work for all positive numbers and a mix of positive negative numbers
     * but will not work for all negative numbers
     * @param numbers
     * @return
     */
    private static int findHighestInListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x,y) -> x>y?x:y);
    }

    private static int addListFunctionalExperiment2(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> y);
    }

    private static int addListFunctionalExperiment(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x);
    }

    private static int mul(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate * nextNumber;
    }

    private static int multiplyListFunctional(List<Integer> newNumbers) {
        return newNumbers.stream().reduce(1, FP02Functional::mul);
    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //Stream of number -> One result value
        //Combine them into one result => One value
        // 0 and (a,b) -> a + b i.e FP02Functional::sum
        return numbers.stream()
                //.reduce(0, FP02Functional::sum);
                //.reduce(0, (a,b) -> a + b); //Lambda expression
                .reduce(0, Integer::sum);

    }

}
