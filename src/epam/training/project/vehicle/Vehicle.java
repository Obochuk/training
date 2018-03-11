package epam.training.project.vehicle;

public abstract class Vehicle {
    private int maxPassengerAmount;
    private double maxSpeed;
    private double maxCargoCapacity;

    public int getMaxPassengerAmount() {
        return maxPassengerAmount;
    }

    public void setMaxPassengerAmount(int maxPassengerAmount) {
        this.maxPassengerAmount = maxPassengerAmount;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public void setMaxCargoCapacity(double maxCargoCapacity) {
        this.maxCargoCapacity = maxCargoCapacity;
    }
}
