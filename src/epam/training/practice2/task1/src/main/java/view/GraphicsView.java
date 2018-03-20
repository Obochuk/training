package view;

import model.graphics.Shape;

public class GraphicsView {

    public static final String ALL_SHAPES_MESSAGE = "The list of shapes: ";
    public static final String TOTAL_AREA_MESSAGE = "Total area of all shapes: ";
    public static final String TOTAL_AREA_RECTANGLES_Message = "Total area of rectangles: ";
    public static final String SORTED_AREA_MESSAGE = "Shapes were sorted by area.";
    public static final String SORTED_COLOR_MESSAGE = "Shapes were sorted by color.";

    public void drawShapes(Shape[] shapes){
        System.out.println(ALL_SHAPES_MESSAGE);
        for (Shape shape: shapes){
            shape.draw();
        }
        System.out.println("\n");
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndResult(String message, Object result){
        System.out.println(message + result);
    }
}
