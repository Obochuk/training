package report;

import entity.Sentence;
import entity.Text;
import entity.Word;

import java.util.List;


public class DetailedReportBuilder {
    private StringBuilder report = new StringBuilder();
    private List<Word> words;

    private DetailedReportBuilder(List<Word> words) {
        this.words = words;
    }

    public static DetailedReportBuilder getInstance(List<Word> words){
        return new DetailedReportBuilder(words);
    }

    public DetailedReportBuilder report(Text text){
        for (Sentence sentence : text.getSentences()) {
            report(sentence);
        }
        return this;
    }

    public DetailedReportBuilder report(Sentence sentence){
        report.append(sentence.getValue());
        for (Word word : words){
            report.append('[').append(sentence.amountOf(word)).append(']');
        }
        report.append(System.getProperty("line.separator"));
        return this;
    }

    public String generate(){
        String generated = new String(report);
        report = new StringBuilder();
        return generated;
    }
}
