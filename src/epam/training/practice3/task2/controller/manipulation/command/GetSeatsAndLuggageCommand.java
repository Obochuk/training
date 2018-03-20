package controller.manipulation.command;

import controller.manipulation.command.Command;
import model.TrainModel;
import model.carriage.Carriage;
import view.TrainView;
import view.constants.ResultMessages;

public class GetSeatsAndLuggageCommand implements Command {

    @Override
    public void execute(TrainModel<? extends Carriage> model, TrainView view) {
        long seats = model.passengerAmount();
        long luggage = model.luggageAmount();
        view.showMessageAndResult(ResultMessages.SEATS, String.valueOf(seats));
        view.showMessageAndResult(ResultMessages.Luggage, String.valueOf(luggage));
    }
}
