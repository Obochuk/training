package controller.command.impl;

import controller.command.Command;
import model.Model;
import model.entity.Word;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.IView;
import view.messages.InputMessages;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateReportCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(GenerateReportCommand.class);

    @Override
    public void execute(Model model, IView view) {
        if (model.initialized()) {
            view.printMessage(InputMessages.ENTER_WORDS);
            String words = InputUtils.readLine();
            view.printMessage(InputMessages.ENTER_REPORT_FILENAME);
            String filename = InputUtils.readLine();
            List<Word> wordList = Arrays.stream(words.split("( )+"))
                    .map(Word::new)
                    .collect(Collectors.toList());
            File reportFile = new File(filename);
            model.writeReportFromSource(wordList, reportFile);
        } else {
            LOGGER.error("You haven't set the source file.");
        }
    }
}
