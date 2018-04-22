package model.task;

import java.io.File;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedData {
    private char firstLetter;
    private Map<File, Long> results;
    private AtomicInteger threadsStarted = new AtomicInteger(1);
    private AtomicInteger threadsEnded = new AtomicInteger();
    private Semaphore semaphore = new Semaphore(0);

    public SharedData(char firstLetter, Map<File, Long> results) {
        this.firstLetter = firstLetter;
        this.results = results;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void threadStarted(){
        threadsStarted.incrementAndGet();
    }

    public void addResult(File file, long amount){
        results.put(file, amount);
    }

    public void threadEnded(){
        threadsEnded.incrementAndGet();
        if (threadsEnded.get() == threadsStarted.get())
            semaphore.release(Integer.MAX_VALUE);
    }

    public Map<File, Long> getResults(){
        try {
            semaphore.acquire();
            return results;
        } catch (InterruptedException ignored){}
        return null;
    }
}
