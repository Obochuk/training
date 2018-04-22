import controller.Controller;
import model.Model;
import view.View;

public class Runner {
    public static void run(){
        new Controller(new Model(), new View()).proceed();
    }
}
