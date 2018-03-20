package controller.manipulation.command;

import controller.manipulation.command.Command;
import controller.utils.InputUtil;
import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;
import view.constants.InputMessages;
import view.constants.ResultMessages;

import java.util.List;

public class FilterBySeatsCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        view.showMessage(InputMessages.INPUT_MIN_SEATS);
        int minSeats = InputUtil.readInt();
        view.showMessage(InputMessages.INPUT_MAX_SEATS);
        int maxSeats = InputUtil.readInt();
        view.showMessage(ResultMessages.CARRIAGES_BY_RANGE_OF_SEAT);
        List<? extends Carriage> carriages = model.filterBySeats(minSeats, maxSeats);
        view.showMessage(view.toString(carriages));
    }
}
