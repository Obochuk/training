package model.graphics.figure;

import model.graphics.Shape;

public class Circle extends Shape {

    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        if (radius < 0)
            throw new IllegalArgumentException("Radius cannot be negative");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", radius=" + radius
                + super.toString());
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}
