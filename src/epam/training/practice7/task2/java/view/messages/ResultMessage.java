package view.messages;

import utils.ResourceManager;

public enum ResultMessage {
    ALL_BOOKS("list.all"),
    BOOKS_BY_AUTHOR ("list.byAuthor"),
    BOOKS_BY_PUBLISHER("list.byPublisher"),
    BOOKS_PRESENTED_AFTER("list.publishedAfter"),
    BOOKS_SORTED_BY_PUBLISHER("list.sorted.byPublisher");

    private String key;

    ResultMessage(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        final String PREFIX = "messages.result.";
        return ResourceManager.INSTANCE.getMessage(PREFIX + key);
    }
}

