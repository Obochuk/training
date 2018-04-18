package generator;

import entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestGeneratePersons {
    private List<Person> people;

    @Before
    public void setUp(){
        people = PersonGenerator.generatePersons(amount);
    }

    @Parameterized.Parameter
    public int amount;

    @Parameterized.Parameters
    public static Iterable<?> data(){
        return Arrays.asList(1, 100, 0);
    }

    @Test
    public void test(){
        assertEquals(amount, people.size());
    }

}
