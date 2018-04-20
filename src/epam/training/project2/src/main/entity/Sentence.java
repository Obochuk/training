package entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {
    private String value;

    private List<Word> wordsOfSentence;

    public Sentence(String value) {
        this.value = value;
        wordsOfSentence = initWordList();
    }

    public String getValue() {
        return value;
    }

    public int amountOf(Word word){
        return Collections.frequency(wordsOfSentence, word);
    }

    public List<Word> getWordsOfSentence() {
        return wordsOfSentence;
    }

    private List<Word> initWordList(){
        return Arrays.stream(value.split("[^\\p{L}'’ʼ‒–—]+"))
                .map(Word::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        return value.equals(sentence.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
