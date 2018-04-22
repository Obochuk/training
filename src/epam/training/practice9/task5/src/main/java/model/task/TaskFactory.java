package model.task;

import java.io.File;

public class TaskFactory {

    public static Runnable createProcessingTask(File file, SharedData data){
        if (file.isDirectory()){
            return new ProcessDirectory(file, data);
        }
        return new ProcessFile(file, data);
    }

}
