package epam.training.project.model.vehicle;

public abstract class Vehicle {
    private int maxPassengerAmount;
    private double maxSpeed;
    private double maxCargoCapacity;

    public int getMaxPassengerAmount() {
        return maxPassengerAmount;
    }

    public void setMaxPassengerAmount(int maxPassengerAmount) throws IllegalArgumentException {
        if (maxPassengerAmount < 0)
            throw new IllegalArgumentException("Max passenger amount in vehicle can not be negative");
        this.maxPassengerAmount = maxPassengerAmount;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) throws IllegalArgumentException {
        if (maxSpeed < 0)
            throw new IllegalArgumentException("Max speed of vehicle cannot be negative");
        this.maxSpeed = maxSpeed;
    }

    public double getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public void setMaxCargoCapacity(double maxCargoCapacity) throws IllegalArgumentException {
        if (maxCargoCapacity < 0)
            throw new IllegalArgumentException("Max cargo capacity in vehicle cannot be negative");
        this.maxCargoCapacity = maxCargoCapacity;
    }
}
