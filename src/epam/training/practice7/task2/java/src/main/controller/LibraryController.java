package controller;

import model.LibraryModel;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.LibraryView;
import view.menu.MainMenu;
import view.resource.messages.ResultMessage;


public class LibraryController {
    private static Logger LOGGER = Logger.getLogger(LibraryController.class);
    private final LibraryModel MODEL = LibraryModel.INSTANCE;
    private final LibraryView VIEW = LibraryView.INSTANCE;

    public void process() {
        VIEW.printMessage(ResultMessage.ALL_BOOKS);
        VIEW.print(MODEL.getBooks());
        while (true) {
            VIEW.printMessage(MainMenu.INSTANCE.getMenu());
            int itemNum = InputUtils.readInt();
            try {
                MainMenuItem choose = MainMenuItem.values()[itemNum - 1];
                choose.proceed();
            } catch (IndexOutOfBoundsException ignored){
                LOGGER.warn("wrong input number");
            }
        }
    }
}