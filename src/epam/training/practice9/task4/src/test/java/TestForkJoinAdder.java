import org.junit.Before;
import org.junit.Test;
import utils.ArrayGenerator;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestForkJoinAdder {
    private int[] arr;

    @Before
    public void setUp(){
        arr = ArrayGenerator.generate(1_000_000, 1, 120);
    }

    @Test
    public void testCompute(){
        ForkJoinAdder adder = new ForkJoinAdder(arr);
        long expected = Arrays.stream(arr).mapToLong(Long::new).sum();
        assertEquals(expected, (long)adder.compute());
    }
}
