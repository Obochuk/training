package model.task;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {
    private char firstLetter;
    private Map<File, Long> results;
    private AtomicInteger threadsStarted = new AtomicInteger(1);
    private AtomicInteger threadsEnded = new AtomicInteger();
    private Lock lock = new ReentrantLock();
    private Condition resultCalculated = lock.newCondition();

    public SharedData(char firstLetter, Map<File, Long> results) {
        this.firstLetter = firstLetter;
        this.results = results;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void threadStarted() {
        threadsStarted.incrementAndGet();
    }

    public void addResult(File file, long amount) {
        results.put(file, amount);
    }

    public void threadEnded() {
        threadsEnded.incrementAndGet();
        if (threadsEnded.get() == threadsStarted.get())
            try {
                lock.lock();
                resultCalculated.signal();
            } finally {
                lock.unlock();
            }
    }

    public Map<File, Long> getResults() {
        try {
            lock.lock();
            resultCalculated.await();
            return results;
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
        return null;
    }
}
