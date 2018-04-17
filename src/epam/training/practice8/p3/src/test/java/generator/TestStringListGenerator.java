package generator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestStringListGenerator {
    private List<String> list;

    @Parameterized.Parameter
    public int elementsAmount;

    @Parameterized.Parameter(1)
    public int stringMaxSize;

    @Before
    public void setUp(){
        list = StringListGenerator.generate(elementsAmount, stringMaxSize);
    }

    @Parameterized.Parameters(name = "{index}: StringListGenerator.generate({0}, {1})")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {5, 8},
                {1_000_000, 589},
                {1, 1}
        });
    }

    @Test
    public void testGenerateAmount(){
        assertEquals(elementsAmount, list.size());
    }

    @Test
    public void testGenerateStringSizes(){
        for (String generated : list) {
            assertTrue(generated.length() <= stringMaxSize);
        }
    }
}
