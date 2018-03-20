package model.graphics;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void draw() {
        System.out.println(toString());
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return " shapeColor='" + shapeColor + '\'' ;
    }
}
