package controller.command;

import model.LibraryModel;
import view.LibraryView;

public interface Command {

    void execute(LibraryModel model, LibraryView view);
}
