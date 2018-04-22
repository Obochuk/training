package batch;

import model.entity.Text;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatchTextReader {
    private InputStreamReader inputStreamReader;

    public BatchTextReader(InputStreamReader inputStreamReader)  {
        this.inputStreamReader = inputStreamReader;
    }

    public Text readBatchOfText(int batchSize) throws IOException {
        char[] buffer = new char[batchSize];
        int size = inputStreamReader.read(buffer);
        if (size < 0)
            throw new EOFException();
        return new Text(new String(buffer, 0, size));
    }
}
