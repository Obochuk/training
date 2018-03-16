package epam.training.practice3.task2.carriage.passangers;

public abstract class PassangersCarriage {
    private int seats;
    private int disabledPeopleSeats;

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
}
