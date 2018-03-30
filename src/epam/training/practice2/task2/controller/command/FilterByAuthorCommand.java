package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import view.messages.InputMessages;
import view.LibraryView;
import view.messages.ResultMessages;

public class FilterByAuthorCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_AUTHOR);
        String author = InputUtils.readLine();
        view.printMessage(ResultMessages.BOOKS_BY_AUTHOR + author);
        view.print(model.getBooksByAuthor(author));
    }
}
