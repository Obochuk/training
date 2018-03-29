package epam.training.project.controller;

import epam.training.project.controller.utils.InputUtil;
import epam.training.project.model.TaxiModel;
import epam.training.project.view.TaxiView;

public class TaxiController {
    private TaxiModel model;
    private TaxiView view;

    public TaxiController(TaxiModel model, TaxiView view) {
        this.model = model;
        this.view = view;
    }

    public void proceed(){
        String menu = MenuItem.MENU;
        while (true){
            view.printMessage(menu);
            int itemNum = InputUtil.readInt();
            MenuItem menuItem = MenuItem.values()[itemNum];
            menuItem.execute(model, view);
        }
    }

}
