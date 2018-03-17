package epam.training.practice3.task2;

import epam.training.practice3.task2.controller.creation.TrainCreationController;
import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;
import epam.training.practice3.task2.view.TrainView;


public class Runner {
    public static void run(){
        TrainModel<PassengersCarriage> model= new TrainModel<>();
        TrainView view = new TrainView();
        TrainCreationController creationController = new TrainCreationController(view, model);
        creationController.process();
    }

}
