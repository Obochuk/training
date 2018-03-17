package epam.training.practice3.task2.model.carriage.passengers.ordinary.sitting;

import epam.training.practice3.task2.model.carriage.passengers.Facility;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;

public class SittingThirdClassCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.LACK_OF_SPACE};
    }

    public SittingThirdClassCar() {
    }

    public SittingThirdClassCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SittingThirdClassCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
