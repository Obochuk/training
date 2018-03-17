package epam.training.practice3.task2.controller.utils;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine(){
        return scanner.nextLine();
    }

    public static int readInt(){
        return scanner.nextInt();
    }
}
