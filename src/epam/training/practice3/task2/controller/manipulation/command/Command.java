package epam.training.practice3.task2.controller.manipulation.command;


import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;

public interface Command {
    void execute(TrainModel<? extends Carriage> model, TrainView view);
}
