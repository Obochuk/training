package model;

import model.task.SharedData;
import model.task.TaskFactory;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Model {
    private final static Logger LOGGER = Logger.getLogger(Model.class);
    private File source;

    public void setAsSource(File source) throws IOException {
        if (!source.exists())
            throw new FileNotFoundException("The specified directory doesn't exists");
        if (!source.canRead())
            throw new IOException("Can`t read the directory");
        this.source = source;
        LOGGER.info("Changed source directory to " + source);
    }

    public boolean initialized(){
        return source != null;
    }

    public Map<File, Long> wordsStartsWithForeachSubdirectory(char c){
        SharedData data = new SharedData(c, new ConcurrentHashMap<>());
        Thread processing = new Thread(TaskFactory.createProcessingTask(source, data));
        processing.start();
        try {
            processing.join();
            return data.getResults();
        } catch (InterruptedException ignored){}
        return null;
    }


}
