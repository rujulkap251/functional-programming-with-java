package src.main.java.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP06PlayingWithStrings {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(courses.stream().collect(Collectors.joining(" ")));
        System.out.println(courses.stream().collect(Collectors.joining(", ")));
        System.out.println(courses.stream().collect(Collectors.joining(",")));
        System.out.println(Arrays.toString("Spring".split("")));

        //Now we want to split each course and create a list of them
        //However, we are getting a list of arrays
        System.out.println(
                courses.stream().map(course -> course.split("")).collect(Collectors.toList())
        );

        //So to flatten these arrays as well, we need a flatmap

        System.out.println(
                courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
        );

        //To print all distinct characters, add distinct
        System.out.println(
                courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
        );

        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(
                courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList())
        );

        //Filtering the lists with same elements
        System.out.println(
                courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).filter(x -> !x.get(0).equals(x.get(1))).collect(Collectors.toList())
        );

        System.out.println(
                courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course.length() == course2.length()).map(course2 -> List.of(course, course2))).filter(x -> !x.get(0).equals(x.get(1))).collect(Collectors.toList())
        );

        //Higher order function - function tha returns another function
        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutOffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutOffReviewScore(90);

        //Intermediate Operations on streams are lazy. Its only when the terminal operation is executed, the intermediate
        //operations are executed in Java, helping Java to be efficient

        //This operator would not work becuase we have created a list using List.of(...) which creates a
        //immutable list
        //courses.replaceAll(String::toUpperCase);
        //System.out.println(courses);

        //Hence, to perform the above operation, we first need to create a mutable list
        List<String> modifiableCourses = new ArrayList<>(courses);
        modifiableCourses.replaceAll(String::toUpperCase);
        System.out.println(modifiableCourses);

        //Also has removeIf method to remove courses based on a condition
        modifiableCourses.removeIf(course -> course.length()<6);
        System.out.println(modifiableCourses);
    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cuttOffScore) {
        return course -> course.getReviewScore() > cuttOffScore;
    }
}
