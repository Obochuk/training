package epam.training.practice3.task2.model.carriage.passengers.compartmental;


import epam.training.practice3.task2.model.carriage.passengers.Facility;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;

public class CompartmentalCar extends PassengersCarriage {
    {
        facilities = new Facility[]{Facility.AIR_CONDITIONING, Facility.HOT_WATER, Facility.BEDDING, Facility.PRIVACY,
                Facility.MEDIUM_SPACE, Facility.ROSETTE};
    }

    public CompartmentalCar() {
    }

    public CompartmentalCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public CompartmentalCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }
}
