package epam.training.practice2.task1.data;

import epam.training.practice2.task1.model.graphics.Shape;
import epam.training.practice2.task1.model.graphics.figure.Circle;
import epam.training.practice2.task1.model.graphics.figure.Rectangle;
import epam.training.practice2.task1.model.graphics.figure.Triangle;

public class DataSource {
    private final static String BLACK = "black";
    private final static String RED = "red";
    private final static String YELLOW = "yellow";
    private final static String WHITE = "white";

    public static Shape[] getShapes(){
        return (new Shape[]{
                new Circle(BLACK, 8.5),
                new Triangle(RED, 8, 2.5),
                new Triangle(YELLOW, 10, 12),
                new Rectangle(WHITE, 1, 1),
                new Circle(RED, 80),
                new Rectangle(BLACK, 8, 15),
                new Rectangle(YELLOW, 15, 15),
                new Triangle(BLACK, 200, 150),
                new Rectangle(YELLOW, 100, 15025),
                new Circle(WHITE, 1),
                new Rectangle(BLACK, 100, 1526)
        });
    }
}
