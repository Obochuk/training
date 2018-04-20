package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSentence {
    private Sentence sentence;

    @Parameterized.Parameter
    public String sentenceValue;

    @Parameterized.Parameter(1)
    public Word word;

    @Parameterized.Parameter(2)
    public int expectedAmount;

    @Parameterized.Parameter(3)
    public List<Word> expectedWords;

    @Before
    public void setUp(){
        sentence = new Sentence(sentenceValue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Hello my darling!", new Word("my"), 1,
                        Arrays.asList(new Word("Hello"), new Word("my"), new Word("darling"))},

                {"What is up?", new Word("Cherry"), 0, Arrays.asList(
                        new Word("What"), new Word("is"), new Word("up"))},

                {"Just do it again, baby boy, and all will be alright, soon future will show to us its willing...",
                new Word("it"), 1, Arrays.stream("Just do it again baby boy and all will be alright soon future will show to us its willing"
                                                        .split(" ")).map(Word::new).collect(Collectors.toList())}
        });
    }


    @Test
    public void testGetWordsOfSentence(){
        assertEquals(expectedWords, sentence.getWordsOfSentence());
    }


}
