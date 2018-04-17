package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringListGenerator {
    private static final Random RANDOM = new Random();

    private static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static List<String> generate(int amount, int maxSize){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int stringSize = 1 + RANDOM.nextInt(maxSize);
            list.add(generateString(stringSize));
        }
        return list;
    }

    private static String generateString(int size){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(letters[RANDOM.nextInt(letters.length)]);
        }
        return builder.toString();
    }
}
