package view.menu;


import controller.MainMenuItem;
import view.resource.ResourceManager;

import java.util.Observable;
import java.util.Observer;

public class MainMenu implements Observer {
    public static final MainMenu INSTANCE = new MainMenu();

    private  String menu;

    private MainMenu(){
        ResourceManager.INSTANCE.addObserver(this);
        menuChanged();
    }

    public String getMenu() {
        return menu;
    }

    private void menuChanged(){
        menu = MenuUtils.generateMenuFromItems(MainMenuItem.values());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ResourceManager){
            menuChanged();
        }
    }
}
