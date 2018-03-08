package epam.training.practice2.task1;

import epam.training.practice2.task1.controller.GraphicsController;
import epam.training.practice2.task1.model.GraphicsModel;
import epam.training.practice2.task1.view.GraphicsView;

public class Main {
    public static void main(String[] args) {
        GraphicsController graphicsController = new GraphicsController(
                new GraphicsModel(), new GraphicsView());
        graphicsController.start();
    }
}
