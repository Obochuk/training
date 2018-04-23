package controller.command;

import view.IView;

public interface Command {
    void execute(IView view);
}
