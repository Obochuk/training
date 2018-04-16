package view.resource.messages;

import view.resource.ResourceManager;

public enum MainMenuMessage {
    CHANGE_LANGUAGE("changeLanguage"),
    LOAD_BOOKS("loadBooks"),
    FILTER_BY_AUTHOR("filter.byAuthor"),
    FILTER_BY_PUBLISHER("filter.byPublisher"),
    FILTER_BY_PUBLISH_DATE("filter.byPublishDate"),
    SORT_BY_PUBLISHER("sort.byPublisher"),
    SAVE_BOOKS("saveBooks"),
    EXIT("exit");

    private String key;

    MainMenuMessage(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        final String PREFIX = "messages.menu.main.";
        return ResourceManager.INSTANCE.getMessage(PREFIX + key);
    }
}
