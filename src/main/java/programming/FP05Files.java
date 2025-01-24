package src.main.java.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

    public static void main(String[] args) throws IOException {
        //The below will read file.txt and print each line
        /*Files.lines(Paths.get("file.txt")).distinct().forEach(System.out::println);*/

        //The below will print all the distinct wprks in the file in alphabetical order (where words starting
        // with capital letters precede)
        /*Files.lines(Paths.get("file.txt")).map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);*/

        //Print all files starting from the root of the project
        //Files.list(Paths.get(".")).forEach(System.out::println);

        //Print all directories
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
    }
}
