import controller.Controller;
import model.RegisterModel;
import view.View;

public class Runner {
    public static void run(){
        Controller controller = new Controller(new RegisterModel(), new View());
        controller.run();
    }
}
