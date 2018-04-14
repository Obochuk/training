package controller.command;

import controller.utils.InputUtils;
import org.apache.log4j.Logger;
import view.messages.InputMessage;

import java.io.FileNotFoundException;

public class LoadBooksCommand implements Command {
    private static Logger LOGGER = Logger.getLogger(LoadBooksCommand.class);
    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.SPECIFY_FILENAME);
        String fileName = InputUtils.readLine();
        try {
            MODEL.readBooks(fileName);
        }catch (FileNotFoundException e){
            LOGGER.error("file with specified name is not found", e);
        }
        VIEW.print(MODEL.getBooks());
    }
}
