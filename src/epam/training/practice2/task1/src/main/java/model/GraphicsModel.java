package model;

import model.graphics.Shape;
import model.graphics.comparator.ShapeAreaComparator;
import model.graphics.comparator.ShapeColorComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class GraphicsModel {
    private Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double calculateTotalArea(){
        return (calculateTotalAreaByPredicate(shape -> true));
    }

    public double calculateTotalArea(Class<? extends Shape> type){
        return (calculateTotalAreaByPredicate(
                (shape -> shape.getClass() == type)
        ));
    }

    private double calculateTotalAreaByPredicate(Predicate<Shape> predicate){
        double sumOfAreas = 0;
        for (Shape shape: shapes){
            if (predicate.test(shape))
                sumOfAreas = sumOfAreas + shape.calcArea();
        }
        return sumOfAreas;
    }

    public Shape[] sortByArea(){
        sort(new ShapeAreaComparator());
        return shapes;
    }

    public Shape[] sortByColor(){
        sort(new ShapeColorComparator());
        return shapes;
    }

    private void sort(Comparator<Shape> comparator){
        Arrays.sort(shapes, comparator);
    }
}