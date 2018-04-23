package view;

public class View implements IView {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printMessageAndResult(String message, Object result) {
        System.out.println(message + " " + result);
    }
}
