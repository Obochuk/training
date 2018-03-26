import generator.Generator;
import generator.RandomListGenerator;
import generator.RandomSetGenerator;
import utils.InputUtil;

import java.util.List;
import java.util.Set;

public class Runner {

    public static void run(){
        System.out.println("Enter amount of values: ");
        int amount = InputUtil.readInt();
        System.out.println("Enter min value: ");
        double min = InputUtil.readDouble();
        System.out.println("Enter max value");
        double max = InputUtil.readDouble();


        Generator generator = new RandomListGenerator();
        List<Double> list = (List<Double>) generator.generate(amount, min, max);
        System.out.println("List: " + list);


        generator = new RandomSetGenerator();
        Set<Double> set = (Set<Double>) generator.generate(amount, min, max);
        System.out.println("Set: " + set);
    }

}
