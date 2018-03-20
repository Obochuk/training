package controller.manipulation;

import controller.utils.InputUtil;
import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;

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
