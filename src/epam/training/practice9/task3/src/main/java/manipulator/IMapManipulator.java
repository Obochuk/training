package src.main.java.manipulator;

import java.util.Map;

public interface IMapManipulator<K, V> {

    void writeData(Map.Entry<K, V> entry);

    void readData(K key);

    Map<K, V> getState();

    void setState(Map<K, V> state);

}
