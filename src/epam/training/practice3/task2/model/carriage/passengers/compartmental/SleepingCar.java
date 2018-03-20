package model.carriage.passengers.compartmental;

import model.carriage.passengers.Facility;
import model.carriage.passengers.PassengersCarriage;

public class SleepingCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.BEDDING, Facility.HOT_WATER, Facility.AIR_CONDITIONING, Facility.LARGE_SPACE,
                Facility.PRIVACY, Facility.ROSETTE, Facility.SINK};
    }

    public SleepingCar() {
    }

    public SleepingCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SleepingCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
