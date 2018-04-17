package filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFilter {
    private static List<String> strings = Arrays.asList("Hello", "capture", "Reno", "cant", "main", "word");

    @Parameterized.Parameter
    public Predicate<String> predicate;

    @Parameterized.Parameter(1)
    public List<String> expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {(Predicate<String>) str -> str.startsWith("c"), Arrays.asList("capture", "cant")},
                {(Predicate<String>) str -> str.length() > 4, Arrays.asList("Hello", "capture")}
        });
    }

    @Test
    public void testFilterArray(){
        String[] expected = (String[]) expectedResult.toArray();
        String[] param = strings.toArray(new String[0]);
        String[] actual = Filter.filter(param, predicate);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFilterList(){
        assertEquals(expectedResult, Filter.filter(strings, predicate));
    }

}
