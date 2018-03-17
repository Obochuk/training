package epam.training.practice3.task2.model.carriage.passengers.compartmental;

import epam.training.practice3.task2.model.carriage.passengers.Facility;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;

public class LuxuryCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.HOT_WATER, Facility.ROSETTE, Facility.BEDDING, Facility.PRIVACY,
                Facility.AIR_CONDITIONING, Facility.LARGE_SPACE};
    }

    public LuxuryCar() {
    }

    public LuxuryCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public LuxuryCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
