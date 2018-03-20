package model.carriage.passengers.ordinary.sitting;

import model.carriage.passengers.Facility;
import model.carriage.passengers.PassengersCarriage;

public class SittingSecondClassCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.LOW_SPACE, Facility.TV};
    }

    public SittingSecondClassCar() {
    }

    public SittingSecondClassCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SittingSecondClassCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
