package controller.command;


import model.LibraryModel;
import view.LibraryView;

public class ExitCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        System.exit(0);
    }
}
