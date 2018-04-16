package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import view.LibraryView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

import java.io.IOException;

public class SaveBooksToFileCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try{
            model.saveBooks(fileName);
        }catch (IOException e){
            view.printErrorMessage(ResultMessages.FILE_ACCESS_ERROR);
        }
    }
}
