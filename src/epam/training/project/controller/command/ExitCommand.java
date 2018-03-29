package epam.training.project.controller.command;


import epam.training.project.model.TaxiModel;
import epam.training.project.view.TaxiView;

public class ExitCommand implements Command{
    @Override
    public void execute(TaxiModel taxiModel, TaxiView taxiView) {
        System.exit(0);
    }
}
