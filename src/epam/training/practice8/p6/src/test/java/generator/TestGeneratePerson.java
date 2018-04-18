package generator;

import entity.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestGeneratePerson {
    private Person person;

    @Before
    public void setUp(){
        person = PersonGenerator.generatePerson();
    }

    @Test
    public void testNameNotNull(){
        assertNotNull(person.getName());
    }

    @Test
    public void testNameHasMultipleParts(){
        String name = person.getName();
        String[] nameParts = name.split(" ");
        assertTrue(nameParts.length > 1);
    }

    @Test
    public void testAge(){
        assertTrue(person.getAge() >= 0);
    }

    @Test
    public void testGender(){
        assertNotNull(person.getGender());
    }

}
