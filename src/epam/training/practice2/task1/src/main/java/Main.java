import controller.GraphicsController;
import model.GraphicsModel;
import view.GraphicsView;

public class Main {
    public static void main(String[] args) {
        GraphicsController graphicsController = new GraphicsController(
                new GraphicsModel(), new GraphicsView());
        graphicsController.start();
    }
}
