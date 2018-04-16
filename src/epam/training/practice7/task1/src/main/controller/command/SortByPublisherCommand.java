package controller.command;


import model.LibraryModel;
import view.LibraryView;
import view.messages.ResultMessages;

public class SortByPublisherCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(ResultMessages.BOOKS_SORTED_BY_PUBLISHER);
        view.print(model.sortBooksByPublisher());
    }
}
