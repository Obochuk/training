package epam.training.practice3.task2.controller.manipulation.command;

import epam.training.practice3.task2.controller.utils.InputUtil;
import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;
import epam.training.practice3.task2.view.constants.InputMessages;
import epam.training.practice3.task2.view.constants.ResultMessages;

import java.util.List;

public class FilterBySeatsCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        view.showMessage(InputMessages.INPUT_MIN_SEATS);
        int minSeats = InputUtil.readInt();
        view.showMessage(InputMessages.INPUT_MAX_SEATS);
        int maxSeats = InputUtil.readInt();
        view.showMessage(ResultMessages.CARRIAGES_BY_RANGE_OF_SEAT);
        Carriage[] carriages = model.filterBySeats(minSeats, maxSeats);
        view.showMessage(view.toString(carriages));
    }
}
