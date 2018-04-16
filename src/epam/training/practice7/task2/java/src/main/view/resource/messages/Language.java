package view.resource.messages;

import view.resource.ResourceManager;

public enum Language {
    EN("changeLanguage.en"),
    UK("changeLanguage.uk");

    private String key;

    Language(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        final String PREFIX = "messages.menu.language.";
        return ResourceManager.INSTANCE.getMessage(PREFIX + key);
    }
}
