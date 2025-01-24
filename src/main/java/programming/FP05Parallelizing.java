package src.main.java.programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        //It takes 346 milliseconds to perform the sum
        //System.out.println(
        //        LongStream.rangeClosed(0, 1000000000).sum()
        //);

        //While it only took 90 milliseconds to perform the below
        //This is because we are parallelizing the operation.
        //Modern day PCs and laptops consist of multiple cores and by parallelizing we make use of those logical cores
        System.out.println(
                LongStream.rangeClosed(0, 1000000000).parallel().sum()
        );

        System.out.println(System.currentTimeMillis() - time);
    }
}
