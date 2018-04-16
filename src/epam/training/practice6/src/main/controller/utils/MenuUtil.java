package controller.utils;


import controller.MenuItem;

public class MenuUtil {

    public static String generateMenuFromItems(MenuItem[] menuItems){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < menuItems.length; i++) {
            builder.append(i + 1).append(") ").append(menuItems[i].getAction()).append(".\n");
        }
        return builder.toString();
    }

}
