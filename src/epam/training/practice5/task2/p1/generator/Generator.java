package generator;

import java.util.Collection;
import java.util.Random;

public interface Generator {
    Random RANDOM = new Random();

    Collection generate(int amount, double min, double max);

}
