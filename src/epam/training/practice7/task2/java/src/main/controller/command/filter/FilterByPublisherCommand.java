package controller.command.filter;

import controller.command.Command;
import utils.InputUtils;
import view.resource.messages.InputMessage;
import view.resource.messages.ResultMessage;

public class FilterByPublisherCommand implements Command {
    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.SPECIFY_PUBLISHER);
        String publisher = InputUtils.readLine();
        VIEW.printMessage(ResultMessage.BOOKS_BY_PUBLISHER + publisher);
        VIEW.print(MODEL.getBooksByPublisher(publisher));
    }
}
