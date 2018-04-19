package src.main.java.manipulator;

import java.util.HashMap;
import java.util.Map;

public class MapManipulator<K, V> implements IMapManipulator<K, V> {

    private Map<K, V> map = new HashMap<>();

    @Override
    public Map<K, V> getState() {
        return map;
    }

    @Override
    public void setState(Map<K, V> state) {
        map = state;
    }

    @Override
    public synchronized void writeData(Map.Entry<K, V> entry) {
        map.put(entry.getKey(), entry.getValue());
    }

    @Override
    public synchronized void readData(K key) {
        map.get(key);
    }
}
