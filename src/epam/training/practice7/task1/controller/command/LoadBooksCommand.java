package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import org.apache.log4j.Logger;
import view.LibraryView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadBooksCommand implements Command {
    private static Logger LOGGER = Logger.getLogger(LoadBooksCommand.class);
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try {
            model.readBooks(fileName);
        }catch (FileNotFoundException e){
            LOGGER.error("file with specified name is not found", e);
        }
        view.print(model.getBooks());
    }
}
