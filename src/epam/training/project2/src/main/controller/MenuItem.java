package controller;

import controller.command.Command;
import controller.command.impl.ExitCommand;
import controller.command.impl.GenerateReportCommand;
import controller.command.impl.GetAmountOfWordsInTextCommand;
import controller.command.impl.InitializeModelCommand;
import model.Model;
import view.IView;

public enum  MenuItem {
    INIT(new InitializeModelCommand(), "set source file"),
    GET_WORDS_AMOUNT(new GetAmountOfWordsInTextCommand(), "get amount of desirable words in source file"),
    GENERATE_REPORT(new GenerateReportCommand(), "generate report about occurrence of desirable word in each sentence"),
    EXIT(new ExitCommand(), "exit");

    MenuItem(Command command, String action) {
        this.command = command;
        this.action = action;
    }

    private Command command;
    private String action;


    public void proceed(Model model, IView view){
        command.execute(model, view);
    }

    @Override
    public String toString() {
        return action;
    }
}
