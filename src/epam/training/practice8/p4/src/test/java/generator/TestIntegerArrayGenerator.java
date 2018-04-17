package generator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIntegerArrayGenerator {
    private Integer[] arr;

    @Parameterized.Parameter
    public int elementsAmount;

    @Before
    public void setUp(){
        arr = IntegerArrayGenerator.generate(elementsAmount);
    }

    @Parameterized.Parameters(name = "{index}: IntegerArrayGenerator.generate({0})")
    public static Iterable<?> data(){
        return Arrays.asList(5, 8, 1000, 6);
    }

    @Test
    public void testGenerate(){
        assertEquals(elementsAmount, arr.length);
    }

}
