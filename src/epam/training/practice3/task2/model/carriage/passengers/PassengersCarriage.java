package epam.training.practice3.task2.model.carriage.passengers;

import epam.training.practice3.task2.model.carriage.Carriage;

public abstract class PassengersCarriage extends Carriage {
    protected Facility[] facilities;
    private int seats;
    private int disabledPeopleSeats;

    public PassengersCarriage() {
    }

    public PassengersCarriage(double maxLoad, double maxSpeed, int seats) {
        this(maxLoad, maxSpeed, seats, 0);
    }

    public PassengersCarriage(double maxLoad, double maxSpeed, int seats, int disabledPeopleSeats) {
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

    public int getAmountOfSeats() {
        return seats + disabledPeopleSeats;
    }

    public int getComfortLevel() {
        int comfortLevel = 0;
        for (Facility facility : facilities) {
            comfortLevel += facility.getComfortLevel();
        }
        return comfortLevel;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", seats amount=" + seats +
                ", disabled people seats amount=" + disabledPeopleSeats;
    }
}
