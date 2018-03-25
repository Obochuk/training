package controller.command;

import model.RegisterModel;
import view.View;

public class ExitCommand implements Command{

    @Override
    public void execute(RegisterModel model, View view) {
        System.exit(0);
    }
}
