package controller.command.language;

import view.resource.messages.Language;

import java.util.Locale;

public enum LanguageMenuItem {
    EN(Locale.ENGLISH, Language.EN),
    UK(new Locale("uk"), Language.UK);

    private Locale locale;
    private Language name;

    LanguageMenuItem(Locale locale, Language name) {
        this.locale = locale;
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
