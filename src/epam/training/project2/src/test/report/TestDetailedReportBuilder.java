package report;

import entity.Sentence;
import entity.Text;
import entity.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestDetailedReportBuilder {
    private DetailedReportBuilder reportBuilder = DetailedReportBuilder.getInstance(
            Arrays.asList(new Word("to"), new Word("is")));

    @Parameterized.Parameter
    public Text text;

    @Parameterized.Parameter(1)
    public String expectedTextReport;

    @Parameterized.Parameter(2)
    public Sentence sentence;

    @Parameterized.Parameter(3)
    public String expectedSentenceReport;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        final String LINE_SEPARATOR = System.getProperty("line.separator");
        return Arrays.asList(new Object[][]{
                {new Text("Hey! There is monkey. You can take it to the zoo"),
                        "Hey! [0][0]" + LINE_SEPARATOR +
                                "There is monkey. [0][1]" + LINE_SEPARATOR +
                                "You can take it to the zoo[1][0]" + LINE_SEPARATOR,

                        new Sentence("It is too dark here..."),
                        "It is too dark here...[0][1]" + LINE_SEPARATOR
                }
        });
    }

    @Test
    public void testReportSentence(){
        assertEquals(expectedSentenceReport, reportBuilder.report(sentence).generate());
    }

    @Test
    public void testReportText(){
        assertEquals(expectedTextReport, reportBuilder.report(text).generate());
    }
}
