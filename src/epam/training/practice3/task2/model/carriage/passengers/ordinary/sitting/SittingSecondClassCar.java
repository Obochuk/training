package epam.training.practice3.task2.model.carriage.passengers.ordinary.sitting;

import epam.training.practice3.task2.model.carriage.passengers.Facility;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;

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
