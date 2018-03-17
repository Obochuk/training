package epam.training.practice3.task2.model.carriage;

public abstract class Carriage {
    private double maxLoad;
    private double maxSpeed;
    private Direction direction;

    public Carriage() {
    }

    public Carriage(double maxLoad, double maxSpeed) {
        this.maxLoad = maxLoad;
        this.maxSpeed = maxSpeed;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", maxLoad=" + maxLoad +
                ", maxSpeed=" + maxSpeed;
    }
}
