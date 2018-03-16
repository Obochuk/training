package epam.training.practice3.task2.carriage.passangers.compartmental;

import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class LuxuryCar extends PassangersCarriage {
    public LuxuryCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public LuxuryCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
        facilities = new Facility[]{Facility.HOT_WATER, Facility.ROSETTE, Facility.BEDDING, Facility.PRIVACY,
                                    Facility.AIR_CONDITIONING, Facility.LARGE_SPACE};
    }
}
