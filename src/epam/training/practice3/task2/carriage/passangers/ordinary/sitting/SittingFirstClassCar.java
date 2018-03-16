package epam.training.practice3.task2.carriage.passangers.ordinary.sitting;

import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class SittingFirstClassCar  extends PassangersCarriage {
    public SittingFirstClassCar(){}

    public SittingFirstClassCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public SittingFirstClassCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }

    {facilities = new Facility[]{Facility.LOW_SPACE, Facility.TV, Facility.AIR_CONDITIONING, Facility.HOT_WATER};}
}
