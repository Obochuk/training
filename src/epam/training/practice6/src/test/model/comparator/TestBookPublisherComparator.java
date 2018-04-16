package model.comparator;

import model.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestBookPublisherComparator {
    private BookPublisherComparator comparator = new BookPublisherComparator();

    private static String defaultName = "Flat";

    @Parameterized.Parameter
    public Book arg1;

    @Parameterized.Parameter(1)
    public Book arg2;

    @Parameterized.Parameter(2)
    public int expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Book ar1 = new Book();
        ar1.setPublisher("abc");
        Book ar2 = new Book();
        ar2.setPublisher("cba");
        Book ar11 = new Book();
        ar11.setPublisher("aaa");
        Book ar12 = new Book();
        ar12.setPublisher("aaa");
        return Arrays.asList(new Object[][]{
                {ar1, ar2, -100},
                {ar11, ar12, 0},
                {ar2, ar1, 100}
        });
    }

    @Test
    public void testCompare(){
        int result = comparator.compare(arg1, arg2);
        if (expectedResult > 0)
            assertTrue(result > 0);
        if (expectedResult < 0)
            assertTrue(result < 0);
        if (expectedResult == 0)
            assertEquals(expectedResult, result);
    }
}
