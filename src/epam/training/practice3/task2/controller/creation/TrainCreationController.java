package epam.training.practice3.task2.controller.creation;


import epam.training.practice3.task2.controller.manipulation.TrainManipulationController;
import epam.training.practice3.task2.controller.utils.InputUtil;
import epam.training.practice3.task2.model.TrainModel;
import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;
import epam.training.practice3.task2.view.TrainView;
import epam.training.practice3.task2.view.constants.InputMessages;
import epam.training.practice3.task2.view.constants.Menu;
import epam.training.practice3.task2.view.constants.ResultMessages;


public class TrainCreationController {
    private TrainView view;
    private TrainModel<? extends Carriage> model;
    final int ADD_CARRIAGE = 1;

    public TrainCreationController(TrainView view, TrainModel<? extends Carriage> model) {
        this.view = view;
        this.model = model;
    }

    public void process() {
        int menuChoose;
        do {
            view.showMessage(Menu.CREATION_MENU);
            menuChoose = InputUtil.readInt();
            if (menuChoose == ADD_CARRIAGE) {
                view.showMessage(InputMessages.CHOOSE_TYPE);
                view.showMessage(CarriageType.MENU);
                int typeChoose = InputUtil.readInt();
                Carriage carriage = CarriageType.values()[typeChoose].getInstance();
                try {
                    model.addCarriage(carriage);
                } catch (ClassCastException e) {
                    view.showMessage(ResultMessages.TYPE_ERROR);
                    continue;
                }
                fillCarriage(carriage);
            }
        } while (menuChoose == ADD_CARRIAGE);
        TrainManipulationController manipulationController = new TrainManipulationController(view, model);
        manipulationController.process();
    }

    private void fillCarriage(Carriage carriage) {
        view.showMessage(InputMessages.INPUT_MAX_LOAD);
        carriage.setMaxLoad(InputUtil.readInt());
        view.showMessage(InputMessages.INPUT_MAX_SPEED);
        carriage.setMaxSpeed(InputUtil.readInt());

        if (carriage instanceof PassengersCarriage) {
            fillCarriage((PassengersCarriage) carriage);
        }
    }

    private void fillCarriage(PassengersCarriage carriage) {
        view.showMessage(InputMessages.INPUT_SEATS);
        carriage.setSeats(InputUtil.readInt());
        view.showMessage(InputMessages.INPUT_DISABLED_SEATS);
        carriage.setDisabledPeopleSeats(InputUtil.readInt());
    }
}
