package epam.training.practice3.task2.carriage.passangers;

public abstract class PassangersCarriage {
    private int seats;
    private int disabledPeopleSeats;
    private boolean bedding;

    public PassangersCarriage(int seats) {
        this(seats, 0);
    }

    public PassangersCarriage(int seats, int disabledPeopleSeats) {
        this(seats, disabledPeopleSeats, false);
    }

    public PassangersCarriage(int seats, int disabledPeopleSeats, boolean bedding) {
        this.seats = seats;
        this.disabledPeopleSeats = disabledPeopleSeats;
        this.bedding = bedding;
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

    public boolean isBedding() {
        return bedding;
    }

    public void setBedding(boolean bedding) {
        this.bedding = bedding;
    }
}
