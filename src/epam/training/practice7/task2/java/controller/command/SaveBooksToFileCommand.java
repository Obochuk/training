package controller.command;

import controller.utils.InputUtils;
import org.apache.log4j.Logger;
import view.messages.InputMessage;

import java.io.IOException;

public class SaveBooksToFileCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(SaveBooksToFileCommand.class);

    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try{
            MODEL.saveBooks(fileName);
        }catch (IOException e){
            LOGGER.error("cannot access specified file", e);
        }
    }
}
