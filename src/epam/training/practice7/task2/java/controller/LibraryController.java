package controller;

import controller.utils.InputUtils;
import view.utils.MenuUtil;
import model.LibraryModel;
import org.apache.log4j.Logger;
import view.LibraryView;
import view.messages.ResultMessage;

public class LibraryController {
    private static Logger LOGGER = Logger.getLogger(LibraryController.class);
    private final LibraryModel MODEL = LibraryModel.INSTANCE;
    private final LibraryView VIEW = LibraryView.INSTANCE;

    public void process() {
        VIEW.printMessage(ResultMessage.ALL_BOOKS);
        VIEW.print(MODEL.getBooks());
        while (true) {
            final String MENU = MenuUtil.generateMenuFromItems(MenuItem.values());
            VIEW.printMessage(MENU);
            int itemNum = InputUtils.readInt();
            try {
                MenuItem choose = MenuItem.values()[itemNum - 1];
                choose.proceed();
            } catch (IndexOutOfBoundsException ignored){
                LOGGER.warn("wrong input number");
            }
        }
    }
}