package model.task;

import batch.BatchTextHandler;
import batch.BatchTextReader;
import model.utils.TextParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;

public class ProcessFile implements Runnable {
    private final static Logger LOGGER = Logger.getLogger(ProcessFile.class);
    private File file;
    private SharedData data;

    public ProcessFile(File file, SharedData data) {
        this.file = file;
        this.data = data;
    }

    @Override
    public void run() {
        try (InputStreamReader reader = new FileReader(file)){
            BatchTextHandler batchTextHandler = new BatchTextHandler(new BatchTextReader(reader));
            AtomicLong amount = new AtomicLong();
            char startsWith = data.getFirstLetter();
            batchTextHandler.doForAllBatches(
                    text -> amount.addAndGet(TextParser.amountOfWordsStartsWith(startsWith, text)));
            data.addResult(file, amount.longValue());
        } catch(IOException e){
            LOGGER.error("Can't read file: " + file);
        } finally {
            data.threadEnded();
        }
    }
}
