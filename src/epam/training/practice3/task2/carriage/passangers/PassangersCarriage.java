package epam.training.practice3.task2.carriage.passangers;

import epam.training.practice3.task2.carriage.Carriage;

import java.util.List;

public abstract class PassangersCarriage extends Carriage{
    private int seats;
    private int disabledPeopleSeats;
    protected Facility[] facilities;

    public PassangersCarriage(){}

    public PassangersCarriage(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public PassangersCarriage(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
        super(maxLoad, maxSpeed);
        this.seats = seats;
        this.disabledPeopleSeats = disabledPeopleSeats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDisabledPeopleSeats() {
        return disabledPeopleSeats;
    }

    public void setDisabledPeopleSeats(int disabledPeopleSeats) {
        this.disabledPeopleSeats = disabledPeopleSeats;
    }

    public Facility[] getFacilities() {
        return facilities;
    }

    public int getComfortLevel(){
        int comfortLevel = 0;
        for (Facility facility : facilities) {
            comfortLevel += facility.getComfortLevel();
        }
        return comfortLevel;
    }
}
