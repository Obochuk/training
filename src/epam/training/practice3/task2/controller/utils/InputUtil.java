package controller.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine(){
        return scanner.nextLine();
    }

    public static int readInt(){
        while (true){
            try {
                return scanner.nextInt();
            }catch (InputMismatchException ignored){}
        }
    }
}
