package model.task;

import java.io.File;

public class ProcessDirectory implements Runnable {
    private File directory;
    private SharedData data;

    public ProcessDirectory(File directory, SharedData data) {
        this.directory = directory;
        this.data = data;
    }


    @Override
    public void run() {
        try {
            File[] subFiles = directory.listFiles();
            for (File file : subFiles) {
                new Thread(TaskFactory.createProcessingTask(file, data)).start();
                data.threadStarted();
            }
        } finally {
            data.threadEnded();
        }
    }
}
