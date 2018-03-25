package controller;

import controller.utils.InputUtils;
import model.RegisterModel;
import view.View;

public class Controller {
    private RegisterModel register;
    private View view;

    public Controller(RegisterModel register, View view) {
        this.register = register;
        this.view = view;
    }

    public void run(){
        final String MENU = Menu.MENU;
        while (true){
            view.printMessageNL(MENU);
            Menu choose = Menu.values()[InputUtils.readInt()];
            choose.execute(register, view);
        }
    }
}
