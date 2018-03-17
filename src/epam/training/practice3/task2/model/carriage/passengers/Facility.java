package epam.training.practice3.task2.model.carriage.passengers;

public enum Facility {
    TV(1), AIR_CONDITIONING(5), HOT_WATER(2), BEDDING(2), MEDIUM_SPACE(3), LARGE_SPACE(6), LOW_SPACE(1), LACK_OF_SPACE(0),
    ROSETTE(2), SINK(2), PRIVACY(2);

    int comfortLevel;

    Facility(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replaceAll("_", " ");
    }
}
