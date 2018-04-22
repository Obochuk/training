package model.entity;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Text {
    private String text;
    private List<Sentence> sentences;

    public Text(String text) {
        this.text = text;
        sentences = initSentenceList();
    }

    public String getText() {
        return text;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    private List<Sentence> initSentenceList(){
        List<Sentence> sentences = new ArrayList<>();

        BreakIterator breakIterator = BreakIterator.getSentenceInstance(Locale.getDefault());
        breakIterator.setText(text);
        int start = breakIterator.first();
        for (int end = breakIterator.next();
             end != BreakIterator.DONE;
             start = end, end=breakIterator.next()){

            sentences.add(new Sentence(text.substring(start, end)));
        }
        return sentences;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        return text.equals(text1.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
