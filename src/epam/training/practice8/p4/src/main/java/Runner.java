import filter.Filter;
import generator.IntegerArrayGenerator;
import generator.StringListGenerator;

import java.util.Arrays;
import java.util.List;

public class Runner {

    private static final int COLLECTION_SIZE = 15;
    private static final int MAX_STRING_SIZE = 20;

    public static void run(){
        Integer[] ints = IntegerArrayGenerator.generate(COLLECTION_SIZE);
        System.out.println("Generated int array: " + Arrays.toString(ints));
        Arrays.sort(ints, (left, right) -> Integer.compare(right, left));
        System.out.println("Sorted array: " + Arrays.toString(ints));

        List<String> strings = StringListGenerator.generate(COLLECTION_SIZE, MAX_STRING_SIZE);
        System.out.println("Generated String list: " + strings);
        strings.sort((left, right) -> right.compareTo(left));
        System.out.println("Sorted String list: " + strings);

        System.out.println("Filter array -> less then 555");
        System.out.println(Arrays.toString(Filter.filter(ints, val -> val < 555)));

        System.out.println("Filter String -> starts with 'c'");
        System.out.println(Filter.filter(strings, str -> str.startsWith("c")));
    }


}
