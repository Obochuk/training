package epam.training.practice3.task2.carriage.passangers.ordinary.sitting;

import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class SittingSecondClassCar extends PassangersCarriage {
    public SittingSecondClassCar(){}

    public SittingSecondClassCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SittingSecondClassCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }

    {facilities = new Facility[]{Facility.LOW_SPACE, Facility.TV};}
}
