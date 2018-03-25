package controller.command;

import model.RegisterModel;
import view.View;
import view.constants.Messages;

public class OutputResultsCommand implements Command{
    @Override
    public void execute(RegisterModel model, View view) {
        view.printMessage(Messages.STUDENTS);
        view.printCollection(model.getStudents());
    }
}
