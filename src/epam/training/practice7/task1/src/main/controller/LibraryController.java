package controller;

import controller.utils.InputUtils;
import model.LibraryModel;
import org.apache.log4j.Logger;
import view.LibraryView;
import view.messages.ResultMessages;
import view.utils.MenuUtil;


public class LibraryController {
    private static Logger LOGGER = Logger.getLogger(LibraryController.class);
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
            try {
                MenuItem choose = MenuItem.values()[itemNum - 1];
                choose.proceed(model, view);
            } catch (IndexOutOfBoundsException ignored){
                LOGGER.warn("wrong input number");
            }
        }
    }
}