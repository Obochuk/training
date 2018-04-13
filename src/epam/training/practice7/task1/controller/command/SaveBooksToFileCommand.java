package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import org.apache.log4j.Logger;
import view.LibraryView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

import java.io.IOException;

public class SaveBooksToFileCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(SaveBooksToFileCommand.class);
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try{
            model.saveBooks(fileName);
        }catch (IOException e){
            LOGGER.error("cannot access specified file", e);
        }
    }
}
