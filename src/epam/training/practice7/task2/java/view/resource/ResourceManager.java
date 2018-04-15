package view.resource;

import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

public class ResourceManager extends Observable {
    public static final ResourceManager INSTANCE = new ResourceManager();

    private final String RESOURCE_FILE = "location.messages";
    private ResourceBundle resourceBundle;

    private ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE, locale);
        setChanged();
        notifyObservers();
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }
}