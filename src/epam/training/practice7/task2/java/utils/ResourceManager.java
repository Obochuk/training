package utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private final String RESOURCE_FILE = "location.messages";
    private ResourceBundle resourceBundle;

    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE, locale);
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }

    public Enumeration getKeySet(){
        return resourceBundle.getKeys();
    }
}
