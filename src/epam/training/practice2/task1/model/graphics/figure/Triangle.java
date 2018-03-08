package epam.training.practice2.task1.model.graphics.figure;

import epam.training.practice2.task1.model.graphics.Shape;

public class Triangle extends Shape {

    private double height;
    private double base;

    public Triangle(String shapeColor, double height, double base) {
        super(shapeColor);
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double calcArea() {
        return height * base / 2;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", base = " + base
                + ", height = " + height + super.toString());
    }
}
