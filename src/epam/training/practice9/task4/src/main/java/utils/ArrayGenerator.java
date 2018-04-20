package src.main.java.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {
    public static int[] generate(int size, int minVal, int maxVal){
        Random random = new Random();
        return IntStream
                .generate(() -> minVal + random.nextInt(maxVal))
                .limit(size)
                .toArray();
    }
}
