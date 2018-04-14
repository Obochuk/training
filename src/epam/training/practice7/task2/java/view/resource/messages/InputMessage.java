package view.resource.messages;

import view.resource.ResourceManager;

public enum InputMessage {
    SPECIFY_AUTHOR("author"),
    SPECIFY_PUBLISHER("publisher"),
    SPECIFY_YEAR("year"),
    SPECIFY_FILENAME("filename"),
    CHOOSE_LANGUAGE("language");

    private String key;

    InputMessage(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        final String PREFIX = "message.input.";
        return ResourceManager.INSTANCE.getMessage(PREFIX + key);
    }
}