package controller;

import controller.utils.InputUtils;
import controller.utils.MenuUtil;
import model.LibraryModel;
import view.LibraryView;
import view.messages.ResultMessages;

public class LibraryController {
    private LibraryModel model;
    private LibraryView view;

    public LibraryController(LibraryModel model, LibraryView view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        view.printMessage(ResultMessages.ALL_BOOKS);
        view.print(model.getBooks());
        final String MENU = MenuUtil.generateMenuFromItems(MenuItem.values());
        while (true) {
            view.printMessage(MENU);
            int itemNum = InputUtils.readInt();
            MenuItem choose = MenuItem.values()[itemNum - 1];
            choose.proceed(model, view);
        }
    }
}