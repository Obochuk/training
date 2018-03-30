package controller;


import controller.command.*;
import model.LibraryModel;
import view.LibraryView;

public enum MenuItem {
    LOAD_BOOKS(new LoadBooksCommand(), "load books from file"),
    GET_BOOKS_BY_AUTHOR(new FilterByAuthorCommand(), "filter books by specified author"),
    GET_BOOKS_BY_PUBLISHER(new FilterByPublisherCommand(), "filter books by specified publisher"),
    GET_BOOKS_PRESENTER_AFTER(new FilterByYearCommand(), "filter books, published after specified year"),
    SORT_BOOKS_BY_PUBLISHER(new SortByPublisherCommand(), "sort books by publisher"),
    SAVE_BOOKS(new SaveBooksToFileCommand(), "save books into specified file"),
    EXIT(new ExitCommand(), "exit");

    private Command command;
    private String action;

    MenuItem(Command command, String action) {
        this.command = command;
        this.action = action;
    }

    public void proceed(LibraryModel model, LibraryView view){
        command.execute(model, view);
    }

    public String getAction() {
        return action;
    }
}
