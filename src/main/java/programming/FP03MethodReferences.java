package src.main.java.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");


        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(x -> System.out.println(x));

        System.out.println("\n----------\n");

        //Static Method reference using System.out::println
        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("\n----------\n");

        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(FP03MethodReferences::print);

        System.out.println("\n----------\n");

        //Method Reference can also be used for object reference like the object of String class
        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);



        //Like in the below case to create a new object
        Supplier<String> supplier = () -> new String();
        //Method reference can also be used to provide constructor reference
        //and this can be used to create new objects
        //using supplier.get()
        Supplier<String> supplier1 = String::new;


    }
}
