package epam.training.project.controller.command;

import epam.training.project.controller.utils.InputUtil;
import epam.training.project.model.TaxiModel;
import epam.training.project.view.Messages;
import epam.training.project.view.TaxiView;

public class FilterBySpeedRangeCommand implements Command{
    @Override
    public void execute(TaxiModel taxiModel, TaxiView taxiView) {
        taxiView.printMessage(Messages.INPUT_MIN_SPEED);
        double min = InputUtil.readDouble();
        taxiView.printMessage(Messages.INPUT_MAX_SPEED);
        double max = InputUtil.readDouble();

        taxiView.printMessage(Messages.FILTERED_BY_SPEED);
        taxiView.printCollection(taxiModel.filterBySpeed(min, max));
    }
}
