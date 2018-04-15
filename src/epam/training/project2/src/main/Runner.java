import entity.Text;
import entity.Word;
import file.BatchTextReader;
import utils.MapUtils;
import utils.TextParser;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    private final static String DETAILED_REPORT_FILE = "detailed.rep";
    private final static String SMALL_REPORT_FILE = "small.rep";

    private final static int BATCH_SIZE = 1024;

    public static void run(String fileName, String ... words) throws FileNotFoundException{
        List<Word> wordList = Arrays.stream(words).map(Word::new).collect(Collectors.toList());

        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
                OutputStreamWriter detailedReportWriter = new OutputStreamWriter(new FileOutputStream(DETAILED_REPORT_FILE));
                OutputStreamWriter smallReportWriter = new OutputStreamWriter(new FileOutputStream(SMALL_REPORT_FILE))) {

            parseAndReport(wordList, reader, detailedReportWriter, smallReportWriter);

        } catch (IOException e) {
            System.err.println("Cant access file");
            e.printStackTrace();
        }

    }

    private static <K> void parseAndReport(List<Word> wordList, InputStreamReader reader,
                                                      OutputStreamWriter detailedReportWriter,
                                                      OutputStreamWriter smallReportWriter) throws IOException{

        Map<Word, Integer> wordsAmount = new HashMap<>();
        BatchTextReader batchTextReader = new BatchTextReader(reader);
        while (true) {
            try {
                Text nextBatch = batchTextReader.readBatchOfText(BATCH_SIZE);
                detailedReportWriter.write(TextParser.generateDetailedReport(nextBatch, wordList));
                MapUtils.increaseValue(wordsAmount, TextParser.numberOfOccurrences(nextBatch, wordList));
            } catch (EOFException e) {
                break;
            }
        }
        writeSmallReport(wordsAmount, smallReportWriter);
    }

    private static <K> void writeSmallReport(Map<K, Integer> map, OutputStreamWriter writer) throws IOException{
        writer.write(MapUtils.sortByValue(map).toString());
    }
}
