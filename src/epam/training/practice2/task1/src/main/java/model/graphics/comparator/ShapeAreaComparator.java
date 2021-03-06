package model.graphics.comparator;

import model.graphics.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {

    public int compare(Shape o1, Shape o2) {
        if (o1.calcArea() > o2.calcArea()) {
            return 1;
        }

        if (o1.calcArea() == o2.calcArea()) {
            return 0;
        }

        return -1;
    }
}
