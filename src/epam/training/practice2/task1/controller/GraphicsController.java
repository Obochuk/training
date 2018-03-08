package epam.training.practice2.task1.controller;

import epam.training.practice2.task1.data.DataSource;
import epam.training.practice2.task1.model.GraphicsModel;
import epam.training.practice2.task1.model.graphics.figure.Rectangle;
import epam.training.practice2.task1.view.GraphicsView;

public class GraphicsController {
    private GraphicsModel model;
    private GraphicsView view;

    public GraphicsController(GraphicsModel model, GraphicsView view) {
        this.model = model;
        this.view = view;
    }

    public void start(){
        model.setShapes(DataSource.getShapes());

        view.drawShapes(model.getShapes());

        view.printMessageAndResult(GraphicsView.TOTAL_AREA_MESSAGE, model.calculateTotalArea());

        view.printMessageAndResult(GraphicsView.TOTAL_AREA_RECTANGLES_Message,
                                    model.calculateTotalArea(Rectangle.class));

        view.printMessage(GraphicsView.SORTED_AREA_MESSAGE);
        view.drawShapes(model.sortByArea());

        view.printMessage(GraphicsView.SORTED_COLOR_MESSAGE);
        view.drawShapes(model.sortByColor());
    }
}