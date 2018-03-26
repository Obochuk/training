package generator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RandomSetGenerator implements Generator {
    @Override
    public Set<Double> generate(int amount, double min, double max) {
        if (min > max)
            throw new IllegalArgumentException("min is bigger then max, min =" + min + ", max=" + max);
        Set<Double> set = new HashSet<>();
        while (set.size() != amount){
            double value = min + (RANDOM.nextDouble() * max);
            set.add(value);
        }
        return set;
    }
}
