package src.main.java;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkJoinAdder extends RecursiveTask<Long>{
    private final static int TASK_SIZE = 20;

    private int[] arr;

    public ForkJoinAdder(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Long compute() {
        if (arr.length < TASK_SIZE){
            return (long)Arrays.stream(arr).sum();
        }else {
            int middle = arr.length / 2;
            ForkJoinAdder adder1 = new ForkJoinAdder(Arrays.copyOfRange(arr, 0, middle));
            adder1.fork();
            ForkJoinAdder adder2 = new ForkJoinAdder(Arrays.copyOfRange(arr, middle, arr.length));
            return adder2.compute() + adder1.join();

        }
    }
}
