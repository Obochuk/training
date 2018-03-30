package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import view.messages.InputMessages;
import view.LibraryView;
import view.messages.ResultMessages;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadBooksCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try{
            model.readBooks(fileName);
            view.print(model.getBooks());
        } catch (FileNotFoundException e){
            view.printErrorMessage(ResultMessages.FILE_NOT_FOUND);
        } catch (IOException e){
            view.printErrorMessage(ResultMessages.FILE_ACCESS_ERROR);
        }
    }
}
