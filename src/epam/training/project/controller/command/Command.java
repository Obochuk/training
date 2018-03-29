package epam.training.project.controller.command;


import epam.training.project.model.TaxiModel;
import epam.training.project.view.TaxiView;

@FunctionalInterface
public interface Command {
    void execute(TaxiModel taxiModel, TaxiView taxiView);
}
