package controller.command;

import controller.utils.InputUtils;
import model.LibraryModel;
import view.LibraryView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

public class FilterByPublisherCommand implements Command {
    @Override
    public void execute(LibraryModel model, LibraryView view) {
        view.printMessage(InputMessages.SPECIFY_PUBLISHER);
        String publisher = InputUtils.readLine();
        view.printMessage(ResultMessages.BOOKS_BY_PUBLISHER + publisher);
        view.print(model.getBooksByPublisher(publisher));
    }
}
