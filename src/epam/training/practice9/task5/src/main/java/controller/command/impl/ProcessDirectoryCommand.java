package controller.command.impl;

import controller.command.Command;
import model.Model;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.IView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;


public class ProcessDirectoryCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(ProcessDirectoryCommand.class);

    @Override
    public void execute(Model model, IView view) {
        if (model.initialized()) {
            view.printMessage(InputMessages.ENTER_CHARACTER);
            char wordsStartsWith = InputUtils.readChar();

            view.printMessage(InputMessages.ENTER_REPORT_FILENAME);
            String filename = InputUtils.readLine();

            Map<File, Long> wordsAmountInEachFile = model.wordsStartsWithForeachSubdirectory(wordsStartsWith);
            view.printMessageAndResult(ResultMessages.AMOUNT_OF_WORDS, wordsAmountInEachFile);

            try(OutputStreamWriter writer = new FileWriter(filename)) {
                writer.write(wordsAmountInEachFile.toString());
            }catch (IOException e){
                LOGGER.error("Can't write report to file", e);
            }
        } else {
            LOGGER.error("You haven't set the source directory.");
        }
    }
}
