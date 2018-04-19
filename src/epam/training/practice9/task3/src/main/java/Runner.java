package src.main.java;


import src.main.java.manipulator.ConcurrentMapManipulator;
import src.main.java.manipulator.IMapManipulator;
import src.main.java.manipulator.MapManipulator;
import src.main.java.utils.CollectionUtils;
import src.main.java.utils.ExecutorUtils;
import src.main.java.utils.generator.MapGenerator;
import src.main.java.utils.generator.TaskGenerator;

import java.util.List;
import java.util.Map;


public class Runner {
    private final static int VALUES_AMOUNT = 200;
    private final static int AMOUNT_OF_RUN = 10;

    public static void run(){
        long concurrentWorkTime = 0;
        for (int i = 0; i < AMOUNT_OF_RUN; i++) {
            concurrentWorkTime += runWithAndReturnTime(new ConcurrentMapManipulator<>());
        }
        System.out.println("ConcurrentMap work time: " + concurrentWorkTime);

        long hashMapWorkTime = 0;
        for (int i = 0; i < AMOUNT_OF_RUN; i++) {
            hashMapWorkTime += runWithAndReturnTime(new MapManipulator<>());
        }
        System.out.println("HashMap work time: " + hashMapWorkTime);
    }

    private static long runWithAndReturnTime(IMapManipulator<Integer, Integer> mapManipulator){
        Map<Integer, Integer> startValues = MapGenerator.generateMap(VALUES_AMOUNT);
        mapManipulator.setState(startValues);
        Map<Integer, Integer> writeValues = MapGenerator.generateMap(VALUES_AMOUNT, VALUES_AMOUNT);
        return runManipulationAndReturnTime(mapManipulator, writeValues);
    }

    private static<K, V> long runManipulationAndReturnTime(IMapManipulator<K, V> mapManipulator,
                                                          Map<K, V> writeData){
        Map<K, V> startState = mapManipulator.getState();
        List<Runnable> readers = TaskGenerator.generateReaders(mapManipulator, startState.keySet());
        List<Runnable> writers = TaskGenerator.generateWriters(mapManipulator, writeData);
        List<Runnable> tasks = CollectionUtils.union(readers, writers);
        return ExecutorUtils.ExecuteAndReturnTime(tasks);
    }


}
