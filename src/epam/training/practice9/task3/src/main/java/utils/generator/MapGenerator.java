package src.main.java.utils.generator;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator {
    private static final int MULTIPLIER = 7;

    public static Map<Integer, Integer> generateMap(int valuesAmount){
        return generateMap(valuesAmount, 0);
    }

    public static Map<Integer, Integer> generateMap(int valuesAmount, int keysFrom){
        Map<Integer, Integer> map = new HashMap<>();
        int value = MULTIPLIER;
        for (int i = keysFrom; i < keysFrom + valuesAmount; i++) {
            map.put(i, value);
            value = value * MULTIPLIER + 1;
        }
        return map;
    }

}
