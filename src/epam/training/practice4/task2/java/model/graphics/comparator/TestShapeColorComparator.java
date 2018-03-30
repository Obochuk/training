package epam.training.practice4.task2.java.model.graphics.comparator;

import model.graphics.figure.Circle;
import model.graphics.figure.Rectangle;
import model.graphics.figure.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestShapeColorComparator {
    ShapeColorComparator comparator = new ShapeColorComparator();
    Circle circle = new Circle("A", 5);
    Triangle triangle = new Triangle("B", 5, 5);
    Rectangle rectangle = new Rectangle("C", 5, 5);

    @Test
    public void testEquals(){
        int circleEquals = comparator.compare(circle, circle);
        assertEquals("The same circles is not equal!", circleEquals, 0);

        int triangleEquals = comparator.compare(triangle, triangle);
        assertEquals("The same triangles is not equal!", triangleEquals, 0);

        int rectangleEquals = comparator.compare(rectangle, rectangle);
        assertEquals("The same rectangles is not equal!", rectangleEquals, 0);
    }

    @Test
    public void testBigger(){
        int testRectangleCircle = comparator.compare(rectangle, circle);
        assertTrue(testRectangleCircle > 0);

        int testTriangleCircle = comparator.compare(triangle, circle);
        assertTrue(testRectangleCircle > 0);

        int testRectangleTriangle = comparator.compare(rectangle, triangle);
        assertTrue(testRectangleTriangle > 0);
    }

    @Test
    public void testSmaller(){
        int testTriangleRectangle = comparator.compare(triangle, rectangle);
        assertTrue(testTriangleRectangle < 0);

        int testCircleTriangle = comparator.compare(circle, triangle);
        assertTrue(testCircleTriangle < 0);

        int testCircleRectangle = comparator.compare(circle, rectangle);
        assertTrue(testCircleRectangle < 2);
    }
}
