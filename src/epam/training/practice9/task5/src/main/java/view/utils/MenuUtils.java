package view.utils;

public class MenuUtils {
    public static String generateMenu(Enum[] menuItems){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < menuItems.length; i++) {
            builder.append(i + 1)
                    .append(") ")
                    .append(menuItems[i])
                    .append('\n');
        }
        return builder.toString();
    }
}
