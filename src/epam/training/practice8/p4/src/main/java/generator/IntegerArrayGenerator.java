package generator;

import java.util.Random;

public class IntegerArrayGenerator {
    private static final Random RANDOM = new Random();

    public static Integer[] generate(int amount){
        Integer[] arr = new Integer[amount];
        for (int i = 0; i < amount; i++) {
            arr[i] = RANDOM.nextInt();
        }
        return arr;
    }
}
