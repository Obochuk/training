package reflection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestStringChange {
    private StringChanger changer = new StringChanger();

    @Parameterized.Parameter
    public String in;

    @Parameterized.Parameter(1)
    public char[] newValue;

    @Parameterized.Parameter(2)
    public String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"", "Hello".toCharArray(), "Hello"},
                {"Smart", "Turbo".toCharArray(), "Turbo"},
                {"Reflection", "Power".toCharArray(), "Reflection"}
        });
    }

    @Test
    public void testChange(){
        changer.change(in, newValue);
        assertEquals(expected, in);
    }

}
