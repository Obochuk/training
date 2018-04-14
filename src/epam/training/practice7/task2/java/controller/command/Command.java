package controller.command;

import model.LibraryModel;
import view.LibraryView;

public interface Command {
    LibraryModel MODEL = LibraryModel.INSTANCE;
    LibraryView VIEW = LibraryView.INSTANCE;

    void execute();
}
