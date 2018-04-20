package model.utils;

import model.entity.Sentence;
import model.entity.Text;
import model.entity.Word;
import report.ReportBuilder;
import utils.MapUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextParser {

    public static int amountOfWord(Word word, Text text){
        return text.getSentences().stream()
                .mapToInt(sentence -> amountOfWord(word, sentence))
                .sum();
    }

    public static int amountOfWord(Word word, Sentence sentence){
        return Collections.frequency(sentence.getWordsOfSentence(), word);
    }

    public static Map<Word, Integer> numberOfOccurrences(Text text, List<Word> words){

        Map<Word, Integer> wordsAmount = new HashMap<>();
        words.forEach(word -> MapUtils.increaseValue(wordsAmount, word, amountOfWord(word, text)));
        return wordsAmount;
    }

    public static String generateReport(Text text, List<Word> words){
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.report(text.getSentences(), (Sentence sentence) ->{
            StringBuilder builder = new StringBuilder();
            for (Word word : words) {
                builder.append("[");
                builder.append(amountOfWord(word, sentence));
                builder.append("]");
            }
            return new String(builder);
        });
        return reportBuilder.generateReport();
    }

}
