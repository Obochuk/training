package controller.command.filter;

import controller.command.Command;
import controller.utils.InputUtils;
import view.messages.InputMessage;
import view.messages.ResultMessage;

public class FilterByYearCommand implements Command {
    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.SPECIFY_YEAR);
        int year = InputUtils.readInt();
        VIEW.printMessage("" + ResultMessage.BOOKS_PRESENTED_AFTER + year);
        VIEW.print(MODEL.getBooksPublishedAfter(year));
    }
}
