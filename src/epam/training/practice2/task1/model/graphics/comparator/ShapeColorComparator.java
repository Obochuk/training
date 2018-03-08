package epam.training.practice2.task1.model.graphics.comparator;

import epam.training.practice2.task1.model.graphics.Shape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (o1.getShapeColor().compareTo(o2.getShapeColor()));
    }
}
