package controller.command.impl;

import controller.command.Command;
import model.Model;
import view.IView;

public class ExitCommand implements Command {
    @Override
    public void execute(Model model, IView view) {
        System.exit(0);
    }
}
