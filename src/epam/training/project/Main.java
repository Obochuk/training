package epam.training.project;

import epam.training.project.controller.TaxiController;
import epam.training.project.model.TaxiModel;
import epam.training.project.view.TaxiView;

public class Main {
    public static void main(String[] args) throws Exception {
        TaxiController controller = new TaxiController(new TaxiModel(), new TaxiView());
        controller.proceed();
    }
}
