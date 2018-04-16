package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestText {
    private Text text;

    @Parameterized.Parameter
    public String textValue;

    @Parameterized.Parameter(1)
    public Word word;

    @Parameterized.Parameter(2)
    public int expectedAmount;

    @Parameterized.Parameter(3)
    public List<Sentence> expectedSentences;

    @Before
    public void setUp(){
        text = new Text(textValue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Hello! Today we are gonna do some important stuff. One of it is catch some type of bugs. Second one is to get rid of it.",
                new Word("it"), 2, Arrays.asList(new Sentence("Hello! "),
                        new Sentence("Today we are gonna do some important stuff. "),
                        new Sentence("One of it is catch some type of bugs. "),
                        new Sentence("Second one is to get rid of it."))
                }
        });
    }

    @Test
    public void testAmountOf(){
        assertEquals(expectedAmount, text.amountOf(word));
    }

    @Test
    public void testGetSentences(){
        assertEquals(expectedSentences, text.getSentences());
    }
}
