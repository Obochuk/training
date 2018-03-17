package epam.training.practice3.task2.controller.manipulation.command;

import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.view.TrainView;
import epam.training.practice3.task2.view.constants.ResultMessages;

public class GetSeatsAndLuggageCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        long seats = model.passengerAmount();
        long luggage = model.luggageAmount();
        view.showMessageAndResult(ResultMessages.SEATS, String.valueOf(seats));
        view.showMessageAndResult(ResultMessages.Luggage, String.valueOf(luggage));
    }
}
