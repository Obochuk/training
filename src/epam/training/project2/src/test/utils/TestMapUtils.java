package utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestMapUtils {
    private static Map<Integer, Integer> startMap = startMap();

    @Parameterized.Parameter
    public Integer key;

    @Parameterized.Parameter(1)
    public Integer value;

    @Parameterized.Parameter(2)
    public Map<Integer, Integer> expectedSingleIncrement;

    @Parameterized.Parameter(3)
    public Map<Integer, Integer> increment;

    @Parameterized.Parameter(4)
    public Map<Integer, Integer> expectedMultipleIncrement;


    private static Map<Integer, Integer> startMap(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(5, 8);
        map.put(0, 125);
        map.put(6, 1);
        return map;
    }

    @Before
    public void setUp(){
        startMap = startMap();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Map<Integer, Integer> increment = new HashMap<>();
        increment.put(2, 9);
        increment.put(6, 5);

        Map<Integer, Integer> incrementSingleResult = new HashMap<>();
        incrementSingleResult.putAll(startMap);
        incrementSingleResult.put(1, 8);

        Map<Integer, Integer> incrementMultipleResult = new HashMap<>();
        incrementMultipleResult.putAll(increment);
        incrementMultipleResult.putAll(startMap);
        incrementMultipleResult.put(6, 6);
        return Arrays.asList(new Object[][]{
                {1, 3, incrementSingleResult, increment, incrementMultipleResult}
        });
    }

    @Test
    public void testIncreaseValueSingle(){
        MapUtils.increaseValue(startMap, key, value);
        assertEquals(expectedSingleIncrement, startMap);
    }

    @Test
    public void testIncreaseValueMultiple(){
        MapUtils.increaseValue(startMap, increment);
        assertEquals(expectedMultipleIncrement, startMap);
    }
}