package model.graphics.figure;

import model.graphics.Shape;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(String shapeColor, double height, double width) {
        super(shapeColor);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", width=" + width
                + ", height=" + height + super.toString());
    }

    @Override
    public double calcArea() {
        return height * width;
    }
}
