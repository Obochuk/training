package controller.manipulation.command;


import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;

public interface Command {
    void execute(TrainModel<? extends Carriage> model, TrainView view);
}
