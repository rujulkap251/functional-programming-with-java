package src.main.java.programming;

import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);

        //printAllNumbersInListStructured(numbers);
        //printAllEvenNumbersInListStructured(numbers);
        int sum  = addListStructured(numbers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(int number:numbers) {
            sum = sum + number;
        }
        return sum;
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for (int number: numbers) {
            System.out.println(number);
        }
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        for (int number: numbers) {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
