package view;

import java.util.Collection;

public class View {

    public void printMessage(String message){
        System.out.print(message);
    }

    public void printMessageNL(String message){
        System.out.println(message);
    }

    public void printCollection(Collection collection){
        int i = 0;
        for (Object elem : collection) {
            System.out.println("\t" + i++ + ") " + elem.toString());
        }
    }

}
