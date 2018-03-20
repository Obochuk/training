package model.graphics.comparator;

import model.graphics.Shape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<Shape> {

    public int compare(Shape o1, Shape o2) {
        return (o1.getShapeColor().compareTo(o2.getShapeColor()));
    }
}
