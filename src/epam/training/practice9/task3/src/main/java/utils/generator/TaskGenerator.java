package src.main.java.utils.generator;

import src.main.java.manipulator.IMapManipulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskGenerator {

    public static <K, V> List<Runnable> generateReaders(IMapManipulator<K, V> mapManipulator,
                                                         Set<K> keys){
        List<Runnable> readers = new ArrayList<>();
        for (K key: keys) {
            readers.add(() -> mapManipulator.readData(key));
        }
        return readers;
    }

    public static <K, V> List<Runnable> generateWriters(IMapManipulator<K, V> mapManipulator,
                                                         Map<K, V> values){
        List<Runnable> writers = new ArrayList<>();
        for (Map.Entry<K, V> entry : values.entrySet()) {
            writers.add(() -> mapManipulator.writeData(entry));
        }
        return writers;
    }

}
