package src.main.java;

import src.main.java.utils.ArrayGenerator;

import java.util.concurrent.ForkJoinPool;

public class Runner {
    private final static int ELEMENTS_AMOUNT = 1_000_000;
    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 100;

    public static void run(){
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        int[] arr = ArrayGenerator.generate(ELEMENTS_AMOUNT, MIN_VALUE, MAX_VALUE);
        long sum = forkJoinPool.invoke(new ForkJoinAdder(arr));
        System.out.println("Result: " + sum);
    }

}
