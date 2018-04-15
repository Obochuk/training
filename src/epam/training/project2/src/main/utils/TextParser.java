package utils;

import entity.Text;
import entity.Word;
import report.DetailedReportBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextParser {

    public static Map<Word, Integer> numberOfOccurrences(Text text, List<Word> words){

        Map<Word, Integer> wordsAmount = new HashMap<>();
        words.forEach(word -> MapUtils.increaseValue(wordsAmount, word, text.amountOf(word)));
        return wordsAmount;
    }

    public static String generateDetailedReport(Text text, List<Word> words){
        return DetailedReportBuilder.getInstance(words).report(text).generate();
    }

}
