package controller;

import model.Model;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.IView;
import view.messages.Menu;

public class Controller {
    private final static Logger LOGGER = Logger.getLogger(Controller.class);

    private Model model;
    private IView view;

    public Controller(Model model, IView view) {
        this.model = model;
        this.view = view;
    }

    public void proceed(){
        while (true){
            view.printMessage(Menu.MENU);
            int choose = InputUtils.readInt() - 1;
            try {
                MenuItem elect = MenuItem.values()[choose];
                elect.proceed(model, view);
            } catch (ArrayIndexOutOfBoundsException e){
                LOGGER.error("Wrong choose value");
            }
        }
    }
}
