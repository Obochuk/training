package view.messages;

import controller.MenuItem;
import view.utils.MenuUtils;

public interface Menu {
    String MENU = MenuUtils.generateMenu(MenuItem.values());
}
