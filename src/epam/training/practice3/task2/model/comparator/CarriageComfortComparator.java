package model.comparator;

import model.carriage.Carriage;
import model.carriage.passengers.PassengersCarriage;

import java.util.Comparator;

public class CarriageComfortComparator implements Comparator<Carriage> {
    @Override
    public int compare(Carriage o1, Carriage o2) {
        if (o1 instanceof PassengersCarriage) {
            if (o2 instanceof PassengersCarriage) {
                PassengersCarriage pc1 = (PassengersCarriage) o1;
                PassengersCarriage pc2 = (PassengersCarriage) o2;
                return pc1.getComfortLevel() - pc2.getComfortLevel();
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}
