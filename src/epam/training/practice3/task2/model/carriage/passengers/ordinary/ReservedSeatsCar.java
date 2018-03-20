package model.carriage.passengers.ordinary;

import model.carriage.passengers.Facility;
import model.carriage.passengers.PassengersCarriage;

public class ReservedSeatsCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.BEDDING, Facility.LOW_SPACE};
    }

    public ReservedSeatsCar() {
    }

    public ReservedSeatsCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public ReservedSeatsCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
