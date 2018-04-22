package controller.command.impl;

import controller.command.Command;
import model.Model;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.IView;
import view.messages.InputMessages;

import java.io.File;
import java.io.IOException;

public class InitializeModelCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(InitializeModelCommand.class);

    @Override
    public void execute(Model model, IView view) {
        view.printMessage(InputMessages.ENTER_SOURCE_PATH);
        String fileName = InputUtils.readLine();
        File sourceFile = new File(fileName);
        try {
            model.setAsSource(sourceFile);
        } catch (IOException e){
            LOGGER.error("Wrong directory", e);
            execute(model, view);
        }
    }
}
