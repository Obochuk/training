package utils;

import java.util.*;

public class MapUtils {
    public static <K> void increaseValue(Map<K, Integer> map, K key, int increase){
        if (map.containsKey(key)){
            int oldAmount = map.get(key);
            map.put(key, oldAmount + increase);
        } else {
            map.put(key, increase);
        }
    }

    public static <K> void increaseValue(Map<K, Integer> map, Map<K, Integer> increase){
        for (Map.Entry<K, Integer> entry: increase.entrySet()){
            increaseValue(map, entry.getKey(), entry.getValue());
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map){
        List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
