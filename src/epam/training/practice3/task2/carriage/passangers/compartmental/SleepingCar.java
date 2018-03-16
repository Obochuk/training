package epam.training.practice3.task2.carriage.passangers.compartmental;

import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class SleepingCar extends PassangersCarriage{
    public SleepingCar(){}

    public SleepingCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SleepingCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }

    {facilities = new Facility[]{Facility.BEDDING, Facility.HOT_WATER, Facility.AIR_CONDITIONING, Facility.LARGE_SPACE,
            Facility.PRIVACY, Facility.ROSETTE, Facility.SINK};}
}
