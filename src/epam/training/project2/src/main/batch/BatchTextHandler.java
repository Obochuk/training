package batch;

import model.entity.Text;
import org.apache.log4j.Logger;

import java.io.EOFException;
import java.io.IOException;
import java.util.function.Consumer;

public class BatchTextHandler {
    private final static Logger LOGGER = Logger.getLogger(BatchTextHandler.class);

    private int batchSize;
    private BatchTextReader batchTextReader;

    public BatchTextHandler(BatchTextReader batchTextReader) {
        this(batchTextReader, 1024);
    }

    public BatchTextHandler(BatchTextReader batchTextReader, int batchSize) {
        this.batchTextReader = batchTextReader;
        this.batchSize = batchSize;
    }

    public void doForAllBatches(Consumer<Text> consumer){
        while (true){
            try {
                Text batch = batchTextReader.readBatchOfText(batchSize);
                consumer.accept(batch);
            } catch (EOFException e){
                return;
            } catch (IOException e){
                LOGGER.error("error reading batch of text", e);
            }
        }
    }
}
