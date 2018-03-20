package model.carriage.freight;

import model.carriage.Carriage;

public class FreightCarriage extends Carriage {
    public FreightCarriage(){}

    public FreightCarriage(double maxLoad, double maxSpeed) {
        super(maxLoad, maxSpeed);
    }
}
