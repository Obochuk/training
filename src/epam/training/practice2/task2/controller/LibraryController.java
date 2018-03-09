package epam.training.practice2.task2.controller;

import epam.training.practice2.task2.controller.utils.InputUtils;
import epam.training.practice2.task2.data.DataSource;
import epam.training.practice2.task2.model.LibraryModel;
import epam.training.practice2.task2.view.InputMessages;
import epam.training.practice2.task2.view.LibraryView;
import epam.training.practice2.task2.view.Menu;
import epam.training.practice2.task2.view.ResultMessages;

public class LibraryController {
    private LibraryModel model;
    private LibraryView view;

    public LibraryController(LibraryModel model, LibraryView view) {
        this.model = model;
        this.view = view;
    }

    public void process(){
        model.setBooks(DataSource.getBooks());

        view.printMessage(ResultMessages.ALL_BOOKS);
        view.print(model.getBooks());
        while (true){
            view.printMessage(Menu.MENU);
            try {
                int itemNum = InputUtils.readInt();
                MenuItem choose = MenuItem.values()[itemNum];
                processMenuItem(choose);
            } catch (NumberFormatException | IndexOutOfBoundsException e){
                System.exit(0);
            }
        }
    }

    private void processMenuItem(MenuItem menuItem){
        switch (menuItem){
            case GET_BOOKS_BY_AUTHOR:
                processBooksByAuthor();
                break;
            case GET_BOOKS_BY_PUBLISHER:
                processBooksByPublisher();
                break;
            case GET_BOOKS_PRESENTER_AFTER:
                processBooksPresentedAfter();
                break;
            case SORT_BOOKS_BY_PUBLISHER:
                processSortByPublisher();
                break;
            default:
                throw new UnsupportedOperationException("There is no any action handled by specified menu item");
        }
    }

    private void processBooksByAuthor(){
        view.printMessage(InputMessages.SPECIFY_AUTHOR);
        String author = InputUtils.readLine();
        view.printMessage(ResultMessages.BOOKS_BY_AUTHOR + author);
        view.print(model.getBooksByAuthor(author));
    }

    private void processBooksByPublisher(){
        view.printMessage(InputMessages.SPECIFY_PUBLISHER);
        String publisher = InputUtils.readLine();
        view.printMessage(ResultMessages.BOOKS_BY_PUBLISHER + publisher);
        view.print(model.getBooksByPublisher(publisher));
    }

    private void processBooksPresentedAfter(){
        try {
            view.printMessage(InputMessages.SPECIFY_YEAR);
            int year = InputUtils.readInt();
            view.printMessage(ResultMessages.BOOKS_PRESENTED_AFTER + year);
            view.print(model.getBooksPublishedAfter(year));
        } catch (Exception e){
            view.printErrorMessage(InputMessages.INPUT_ERROR_MESSAGE);
            processBooksPresentedAfter();
        }
    }

    private void processSortByPublisher(){
        view.printMessage(ResultMessages.BOOKS_SORTED_BY_PUBLISHER);
        view.print(model.sortBooksByPublisher());
    }
}