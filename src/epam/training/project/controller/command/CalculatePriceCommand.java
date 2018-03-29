package epam.training.project.controller.command;

import epam.training.project.model.TaxiModel;
import epam.training.project.view.Messages;
import epam.training.project.view.TaxiView;

public class CalculatePriceCommand implements Command
{
    @Override
    public void execute(TaxiModel taxiModel, TaxiView taxiView) {
        taxiView.printMessage(Messages.PRICE);
        taxiView.printResult(taxiModel.getPrice());
    }
}
