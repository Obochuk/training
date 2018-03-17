package epam.training.practice3.task2.controller.manipulation;

import epam.training.practice3.task2.controller.manipulation.command.*;

public enum ManipulationMenuItem {
    FILTER_BY_SEATS_AMOUNT(new FilterBySeatsCommand(), "get carriages that have amount of seats that in specified range"),
    SORT_BY_COMFORT(new SortByComfortCommand(), "get carriages sorted by comfort level"),
    GET_SEATS_LUGGAGE(new GetSeatsAndLuggageCommand(), "get amount of seats and luggage"),
    EXIT(new ExitCommand(), "exit");

    private Command command;
    private String action;
    public final static String MENU = getMenu();

    ManipulationMenuItem(Command command, String action) {
        this.command = command;
        this.action = action;
    }

    public Command getCommand() {
        return command;
    }

    private static String getMenu(){
        StringBuilder builder = new StringBuilder();
        for (ManipulationMenuItem item : ManipulationMenuItem.values()) {
            builder.append(item.ordinal()).append(") ").append(item.action).append('\n');
        }
        return builder.toString();
    }
}
