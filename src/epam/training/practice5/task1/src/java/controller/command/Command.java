package controller.command;

import model.RegisterModel;
import view.View;

public interface Command {
    void execute(RegisterModel model, View view);
}
