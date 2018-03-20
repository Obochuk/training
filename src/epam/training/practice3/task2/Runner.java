import controller.creation.TrainCreationController;
import model.TrainModel;
import model.carriage.passengers.PassengersCarriage;
import view.TrainView;

public class Runner {
    public static void run(){
        TrainModel<PassengersCarriage> model= new TrainModel<>(PassengersCarriage.class);
        TrainView view = new TrainView();
        TrainCreationController creationController = new TrainCreationController(view, model);
        creationController.process();
    }

}
