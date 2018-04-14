package controller.command.filter;

import controller.command.Command;
import controller.utils.InputUtils;
import view.messages.InputMessage;
import view.messages.ResultMessage;

public class FilterByAuthorCommand implements Command {

    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.SPECIFY_AUTHOR);
        String author = InputUtils.readLine();
        VIEW.printMessage(ResultMessage.BOOKS_BY_AUTHOR + author);
        VIEW.print(MODEL.getBooksByAuthor(author));
    }
}
