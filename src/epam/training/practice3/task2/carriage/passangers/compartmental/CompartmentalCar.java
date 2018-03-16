package epam.training.practice3.task2.carriage.passangers.compartmental;


import epam.training.practice3.task2.carriage.passangers.Facility;
import epam.training.practice3.task2.carriage.passangers.PassangersCarriage;

public class CompartmentalCar extends PassangersCarriage {
    public CompartmentalCar(){}

    public CompartmentalCar(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public CompartmentalCar(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed, seats, disabledPeopleSeats);
    }

    {facilities = new Facility[]{Facility.AIR_CONDITIONING, Facility.HOT_WATER, Facility.BEDDING, Facility.PRIVACY,
            Facility.MEDIUM_SPACE, Facility.ROSETTE};}
}
