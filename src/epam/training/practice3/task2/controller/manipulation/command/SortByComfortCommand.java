package epam.training.practice3.task2.controller.manipulation.command;

import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;
import epam.training.practice3.task2.view.constants.ResultMessages;

import java.util.List;

public class SortByComfortCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        view.showMessage(ResultMessages.CARRIAGES_BY_COMFORT);
        model.sortCarriagesByComfort();
        view.showMessage(view.toString(model.getTrain()));
    }
}
