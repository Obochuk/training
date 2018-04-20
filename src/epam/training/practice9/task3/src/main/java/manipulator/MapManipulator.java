package src.main.java.manipulator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapManipulator<K, V> implements IMapManipulator<K, V> {

    private Map<K, V> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public Map<K, V> getState() {
        return map;
    }

    @Override
    public void setState(Map<K, V> state) {
        map = state;
    }

    @Override
    public void writeData(Map.Entry<K, V> entry) {
        try {
            lock.writeLock().lock();
            map.put(entry.getKey(), entry.getValue());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void readData(K key) {
        try {
            lock.readLock().lock();
            map.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }
}
