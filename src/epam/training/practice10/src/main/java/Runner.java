import controller.Controller;
import view.View;

public class Runner {
    public static void run(){
        new Controller(new View()).process();
    }
}
