package epam.training.project.controller;

import epam.training.project.controller.command.*;
import epam.training.project.model.TaxiModel;
import epam.training.project.view.TaxiView;

public enum MenuItem {
    CALCULATE_PRICE(new CalculatePriceCommand(), "Calculate price of taxi park"),
    SORT_BY_CONSUMPTION(new SortByFuelConsumptionCommand(), "Sort taxi park by fuel consumption"),
    FILTER_BY_SPEED(new FilterBySpeedRangeCommand(), "Filter cars in taxi park by speed range"),
    EXIT(new ExitCommand(), "Exit");

    public static final String MENU = generateMenu();

    Command command;
    String action;

    MenuItem(Command command, String action) {
        this.command = command;
        this.action = action;
    }

    public void execute(TaxiModel taxiModel, TaxiView taxiView){
        command.execute(taxiModel, taxiView);
    }

    private static String generateMenu(){
        StringBuilder builder = new StringBuilder();
        MenuItem[] values = MenuItem.values();
        for (int i = 0; i < values.length; i++) {
            MenuItem menuItem = values[i];
            builder.append(i).append(". ").append(menuItem.action).append('\n');
        }
        return builder.toString();
    }
}
