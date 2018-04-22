package model.utils;

import model.entity.Sentence;
import model.entity.Text;

public class TextParser {

    public static long amountOfWordsStartsWith(char c, Text text){
        return text.getSentences().stream()
                .mapToLong(sentence -> amountOfWordsStartsWith(c, sentence))
                .sum();
    }

    public static long amountOfWordsStartsWith(char c, Sentence sentence){
        return sentence.getWordsOfSentence().stream()
                .filter(word -> !word.isEmpty() && word.charAt(0) == c)
                .count();
    }

}
