package view.utils;

public class MenuUtil {

    public static String generateMenuFromItems(Enum[] menuItems){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < menuItems.length; i++) {
            builder.append(i + 1).append(") ").append(menuItems[i].toString()).append(".\n");
        }
        return builder.toString();
    }

}
