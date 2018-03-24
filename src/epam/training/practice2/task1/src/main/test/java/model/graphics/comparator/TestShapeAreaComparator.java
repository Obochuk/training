package model.graphics.comparator;

import model.graphics.figure.Circle;
import model.graphics.figure.Rectangle;
import model.graphics.figure.Triangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestShapeAreaComparator {
    ShapeAreaComparator comparator = new ShapeAreaComparator();

    Circle circle = new Circle("", 5);
    Triangle triangle = new Triangle("", 5, 8);
    Rectangle rectangle = new Rectangle("", 5, 5);

    @Test
    public void testEquals(){
        int circleEquals = comparator.compare(circle, circle);
        assertEquals("The same circles is not equal!", 0, circleEquals);

        int triangleEquals = comparator.compare(triangle, triangle);
        assertEquals("The same triangles is not equal!", 0, triangleEquals);

        int rectangleEquals = comparator.compare(rectangle, rectangle);
        assertEquals("The same rectangles is not equal!", 0, rectangleEquals);
    }

    @Test
    public void testBigger(){
        int testCircleTriangle = comparator.compare(circle, triangle);
        assertTrue(testCircleTriangle > 0);

        int testCircleRectangle = comparator.compare(circle, rectangle);
        assertTrue(testCircleRectangle > 0);

        int testRectangleTriangle = comparator.compare(rectangle, triangle);
        assertTrue(testRectangleTriangle > 0);
    }

    @Test
    public void testSmaller(){
        int testTriangleRectangle = comparator.compare(triangle, rectangle);
        assertTrue(testTriangleRectangle < 0);

        int testRectangleCircle = comparator.compare(rectangle, circle);
        assertTrue(testRectangleCircle < 0);

        int testTriangleCircle = comparator.compare(triangle, circle);
        assertTrue(testTriangleCircle < 0);
    }
}
