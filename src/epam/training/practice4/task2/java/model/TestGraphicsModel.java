package epam.training.practice4.task2.java.model;

import model.graphics.Shape;
import model.graphics.figure.Circle;
import model.graphics.figure.Rectangle;
import model.graphics.figure.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestGraphicsModel {
    GraphicsModel model = new GraphicsModel();

    @Test
    public void testModel(){
        Shape[] shapes = new Shape[]{
                new Triangle("", 5, 5),
                new Rectangle("", 5, 5),
                new Circle("", 5)
        };

        model.setShapes(shapes);

        assertEquals(shapes, model.getShapes());

        assertEquals(116.04, model.calculateTotalArea(), 0.1);

        assertEquals(12.5, model.calculateTotalArea(Triangle.class), 0.1);
    }
}
