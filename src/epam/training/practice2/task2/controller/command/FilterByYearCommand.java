package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import view.messages.InputMessages;
import view.LibraryView;
import view.messages.ResultMessages;

public class FilterByYearCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        try {
            view.printMessage(InputMessages.SPECIFY_YEAR);
            int year = InputUtils.readInt();
            view.printMessage(ResultMessages.BOOKS_PRESENTED_AFTER + year);
            view.print(model.getBooksPublishedAfter(year));
        } catch (Exception e){
            view.printErrorMessage(ResultMessages.INPUT_ERROR_MESSAGE);
            execute(model, view);
        }
    }
}
