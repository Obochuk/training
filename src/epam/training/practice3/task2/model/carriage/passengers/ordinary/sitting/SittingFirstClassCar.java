package model.carriage.passengers.ordinary.sitting;

import model.carriage.passengers.Facility;
import model.carriage.passengers.PassengersCarriage;

public class SittingFirstClassCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.LOW_SPACE, Facility.TV, Facility.AIR_CONDITIONING, Facility.HOT_WATER};
    }

    public SittingFirstClassCar() {
    }

    public SittingFirstClassCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SittingFirstClassCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
