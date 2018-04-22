package controller;

import controller.command.Command;
import controller.command.impl.ExitCommand;
import controller.command.impl.InitializeModelCommand;
import controller.command.impl.ProcessDirectoryCommand;
import model.Model;
import view.IView;

public enum  MenuItem {
    INIT(new InitializeModelCommand(), "set source directory"),
    PROCESS_DIRECTORY(new ProcessDirectoryCommand(), "get amount of words that starts with specified character " +
                                                        "for every text file in the source directory"),
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
