package controller.manipulation.command;

import controller.manipulation.command.Command;
import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;

public class ExitCommand implements Command {
    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        System.exit(0);
    }
}
