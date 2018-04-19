package src.main.java.manipulator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapManipulator<K, V> implements IMapManipulator<K, V>{
    private Map<K, V> map = new ConcurrentHashMap<>();

    @Override
    public Map<K, V> getState() {
        return map;
    }

    @Override
    public void setState(Map<K, V> state) {
        map = new ConcurrentHashMap<>(state);
    }

    @Override
    public void writeData(Map.Entry<K, V> entry) {
        map.put(entry.getKey(), entry.getValue());
    }

    @Override
    public void readData(K key) {
        map.get(key);
    }
}
