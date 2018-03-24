package model.graphics.figure;

import model.graphics.Shape;

public class Triangle extends Shape {

    private double height;
    private double base;

    public Triangle(String shapeColor, double height, double base) {
        super(shapeColor);
        if (height < 0 || base < 0)
            throw new IllegalArgumentException();
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
