package controller.command.constants;

public interface RegexExpressions {
    String NAME_EXPR = "[a-zA-Z][a-zA-Z']{1,14}";
    String FULL_NAME_EXPR = '^' + NAME_EXPR + "([- ]" + NAME_EXPR + ")*$";

    String DAY_EXPR = "0?[1-9]|[12][0-9]|3[01]";
    String MONTH_EXPR = "0?[1-9]|1[0-2]";
    String YEAR_EXPR = "19\\d{2}|20\\d{2}";
    String DATE_EXPR = "^(" + DAY_EXPR + ")-(" + MONTH_EXPR + ")-(" + YEAR_EXPR + ")$";

    String PHONE_EXPR = "^((\\(\\d{1,3}\\))|\\d{1,3})([- ]?\\d+)+$";

    String ADDRESS_EXPR = "^(\\d)+\\s+([a-zA-Z]+[- ]*)+(\\d)*$";
}
