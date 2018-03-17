package epam.training.practice3.task2.controller.manipulation;

import epam.training.practice3.task2.controller.utils.InputUtil;
import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;

public class TrainManipulationController {
    private TrainView view;
    private TrainModel<? extends Carriage> model;

    public TrainManipulationController(TrainView view, TrainModel<? extends Carriage> model) {
        this.view = view;
        this.model = model;
    }

    public void process(){
        while (true){
            view.showMessage(ManipulationMenuItem.MENU);
            int choose = InputUtil.readInt();
            ManipulationMenuItem chooseItem = ManipulationMenuItem.values()[choose];
            chooseItem.getCommand().execute(model, view);
        }
    }
}
