package controller.command.impl;

import controller.command.Command;
import model.Model;
import model.entity.Word;
import org.apache.log4j.Logger;
import utils.InputUtils;
import utils.MapUtils;
import view.IView;
import view.messages.InputMessages;
import view.messages.ResultMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GetAmountOfWordsInTextCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(GetAmountOfWordsInTextCommand.class);

    @Override
    public void execute(Model model, IView view) {
        if (model.initialized()) {
            view.printMessage(InputMessages.ENTER_WORDS);
            String words = InputUtils.readLine();
            List<Word> wordList = Arrays.stream(words.split("( )+"))
                    .map(Word::new)
                    .collect(Collectors.toList());

            Map<Word, Integer> wordsAmount = model.getAmountOfWordsInSource(wordList);
            Map<Word, Integer> wordsOccurrenceSortedByAmount = MapUtils.sortByValue(wordsAmount);
            view.printMessageAndResult(ResultMessages.AMOUNT_OF_WORDS, wordsOccurrenceSortedByAmount);
        } else {
            LOGGER.error("You haven't set the source file.");
        }
    }
}
