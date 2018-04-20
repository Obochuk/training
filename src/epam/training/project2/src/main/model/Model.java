package model;

import batch.BatchTextHandler;
import batch.BatchTextReader;
import model.entity.Word;
import model.utils.TextParser;
import org.apache.log4j.Logger;
import utils.MapUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final static Logger LOGGER = Logger.getLogger(Model.class);
    private File source;

    public void setAsSource(File source) throws IOException {
        if (!source.isFile())
            throw new FileNotFoundException("It is not a file: " + source);
        if (!source.canRead())
            throw new IOException("Can`t read the file");
        this.source = source;
        LOGGER.info("Changed source file to " + source.getAbsolutePath());
    }

    public boolean initialized(){
        return source != null;
    }

    public Map<Word, Integer> getAmountOfWordsInSource(List<Word> words) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(source))) {
            BatchTextHandler batchTextHandler = new BatchTextHandler(new BatchTextReader(reader));

            Map<Word, Integer> wordsAmount = new HashMap<>();
            batchTextHandler.doForAllBatches((text) -> {
                for (Word word : words) {
                    int amountWordInText = TextParser.amountOfWord(word, text);
                    MapUtils.increaseValue(wordsAmount, word, amountWordInText);
                }
            });
            return wordsAmount;
        } catch (IOException e) {
            LOGGER.fatal("Can`t read the source file", e);
        }
        return null;
    }

    public void writeReportFromSource(List<Word> words, File reportTo) {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(source))) {
            BatchTextHandler batchTextHandler = new BatchTextHandler(new BatchTextReader(reader));

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(reportTo));
            writer.write(words.toString() + System.getProperty("line.separator"));
            batchTextHandler.doForAllBatches((text) -> {
                String report = TextParser.generateReport(text, words);
                try {
                    writer.write(report);
                } catch (IOException e) {
                    LOGGER.error("Can`t write report", e);
                }
            });
            writer.flush();
            LOGGER.info("Report written to " + reportTo.getAbsolutePath());
        } catch (IOException e) {
            LOGGER.fatal("Can't access the file", e);
        }
    }
}
