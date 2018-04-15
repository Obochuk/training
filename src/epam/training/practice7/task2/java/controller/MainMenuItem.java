package controller;

import controller.command.*;
import controller.command.filter.FilterByAuthorCommand;
import controller.command.filter.FilterByPublisherCommand;
import controller.command.filter.FilterByYearCommand;
import controller.command.language.ChangeLanguageCommand;
import view.resource.messages.MainMenuMessage;

public enum MainMenuItem {
    CHANGE_LANGUAGE(new ChangeLanguageCommand(), MainMenuMessage.CHANGE_LANGUAGE),
    LOAD_BOOKS(new LoadBooksCommand(), MainMenuMessage.LOAD_BOOKS),
    GET_BOOKS_BY_AUTHOR(new FilterByAuthorCommand(), MainMenuMessage.FILTER_BY_AUTHOR),
    GET_BOOKS_BY_PUBLISHER(new FilterByPublisherCommand(), MainMenuMessage.FILTER_BY_PUBLISHER),
    GET_BOOKS_PRESENTER_AFTER(new FilterByYearCommand(), MainMenuMessage.FILTER_BY_PUBLISH_DATE),
    SORT_BOOKS_BY_PUBLISHER(new SortByPublisherCommand(), MainMenuMessage.SORT_BY_PUBLISHER),
    SAVE_BOOKS(new SaveBooksToFileCommand(), MainMenuMessage.SAVE_BOOKS),
    EXIT(new ExitCommand(), MainMenuMessage.EXIT);

    private Command command;
    private MainMenuMessage message;

    MainMenuItem(Command command, MainMenuMessage message) {
        this.command = command;
        this.message = message;
    }

    public void proceed(){
        command.execute();
    }

    @Override
    public String toString() {
        return message.toString();
    }
}
