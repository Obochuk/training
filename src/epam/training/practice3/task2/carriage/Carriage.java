package epam.training.practice3.task2.carriage;

public abstract class Carriage {
    private double maxLoad;
    private double maxSpeed;
    private Direction direction;

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
}
