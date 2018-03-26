package generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RandomListGenerator implements Generator {
    @Override
    public List<Double> generate(int amount, double min, double max) {
        if (min > max)
            throw new IllegalArgumentException("min is bigger then max, min =" + min + ", max=" + max);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            double value = min + (RANDOM.nextDouble() * max);
            list.add(value);
        }

        return list;
    }
}
