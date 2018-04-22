package controller.command;

import model.Model;
import view.IView;

public interface Command {
    void execute(Model model, IView view);
}
