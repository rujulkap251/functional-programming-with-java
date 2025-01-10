package src.main.java.programming;

import java.util.List;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 4, 6, 12, 3, 8, 2, 9, 10, 14, 12, 3);
        List<Integer> newNumbers = List.of(12, 3, 4, 6);
        int sum  = addListFunctional(numbers);
        //int mul  = multiplyListFunctional(newNumbers);
        System.out.println(sum);
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
