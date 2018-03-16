package epam.training.practice3.task2.carriage.passangers.ordinary;

import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class ReservedSeatsCar extends PassangersCarriage {
    public ReservedSeatsCar(){}

    public ReservedSeatsCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public ReservedSeatsCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }

    {facilities = new Facility[]{Facility.BEDDING, Facility.LOW_SPACE};}
}
