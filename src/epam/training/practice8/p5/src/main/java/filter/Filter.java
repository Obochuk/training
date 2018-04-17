package filter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static<T> T[] filter(T[] arr, Predicate<? super T> predicate){
        List<T> filtered = filter(Arrays.asList(arr), predicate);
        return (T[])filtered.toArray();
    }

    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate){
        List<T> filtered = new ArrayList<>();
        for (T elem : list) {
            if (predicate.test(elem)){
                filtered.add(elem);
            }
        }
        return filtered;
    }

}
