package epam.training.practice3.task2.controller.manipulation.command;

import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;

public class ExitCommand implements Command {
    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        System.exit(0);
    }
}
