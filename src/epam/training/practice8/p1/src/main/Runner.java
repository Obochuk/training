import reflection.StringChanger;
import utils.InputUtils;

public class Runner {
    private final static String CHANGE_TO = "HOMETOWN";

    public static void run(){
        String str = "Hello";
        System.out.println("Initial string: " + str);
        StringChanger changer = new StringChanger();
        changer.change(str, CHANGE_TO.toCharArray());
        System.out.println("New value: " + str);
        System.out.println("Enter String to change: ");
        String input = InputUtils.readLine();
        changer.change(input, CHANGE_TO.toCharArray());
        System.out.println("New value: " + input);
    }

}
