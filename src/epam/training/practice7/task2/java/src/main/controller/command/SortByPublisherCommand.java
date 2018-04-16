package controller.command;

import view.resource.messages.ResultMessage;

public class SortByPublisherCommand implements Command {
    @Override
    public void execute() {
        VIEW.printMessage(ResultMessage.BOOKS_SORTED_BY_PUBLISHER);
        VIEW.print(MODEL.sortBooksByPublisher());
    }
}
