package view.menu;


import controller.command.language.LanguageMenuItem;
import view.resource.ResourceManager;

import java.util.Observable;
import java.util.Observer;

public class LanguageMenu implements Observer {

    public static final LanguageMenu INSTANCE = new LanguageMenu();

    private  String menu;

    private LanguageMenu(){
        ResourceManager.INSTANCE.addObserver(this);
        menuChanged();
    }

    public String getMenu() {
        return menu;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ResourceManager){
            menuChanged();
        }
    }

    private void menuChanged(){
        menu = MenuUtils.generateMenuFromItems(LanguageMenuItem.values());
    }
}
