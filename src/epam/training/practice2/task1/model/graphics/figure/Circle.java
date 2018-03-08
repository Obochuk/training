package epam.training.practice2.task1.model.graphics.figure;

import epam.training.practice2.task1.model.graphics.Shape;

public class Circle extends Shape {

    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", radius=" + radius
                + super.toString());
    }

    @Override
    public double calcArea() {
        return 2 * Math.PI * radius;
    }
}
