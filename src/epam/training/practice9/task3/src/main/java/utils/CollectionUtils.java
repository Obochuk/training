package src.main.java.utils;

import java.util.List;

public class CollectionUtils {

    public static<T> List<T> union(List<T> first, List<T>... concat){
        List<T> result = first;
        for (List<T> list : concat) {
            result.addAll(list);
        }
        return result;
    }

}
