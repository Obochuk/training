package epam.training.project.controller.command;

import epam.training.project.model.TaxiModel;
import epam.training.project.view.Messages;
import epam.training.project.view.TaxiView;

public class SortByFuelConsumptionCommand implements Command{
    @Override
    public void execute(TaxiModel taxiModel, TaxiView taxiView) {
        taxiView.printMessage(Messages.SORTED_BY_CONSUMPTION);
        taxiView.printCollection(taxiModel.sortByFuelConsumption());
    }
}
