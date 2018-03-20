package controller.manipulation.command;

import controller.manipulation.command.Command;
import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;
import view.constants.ResultMessages;

import java.util.List;

public class SortByComfortCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        view.showMessage(ResultMessages.CARRIAGES_BY_COMFORT);
        model.sortCarriagesByComfort();
        view.showMessage(view.toString(model.getTrain()));
    }
}
