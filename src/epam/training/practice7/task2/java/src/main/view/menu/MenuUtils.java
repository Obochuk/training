package view.menu;

public class MenuUtils {

    public static String generateMenuFromItems(Object[] menuItems){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < menuItems.length; i++) {
            builder.append(i + 1).append(") ").append(menuItems[i].toString()).append(".\n");
        }
        return builder.toString();
    }

}
