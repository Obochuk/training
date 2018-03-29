package epam.training.project.controller.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){
        try {
            return reader.readLine();
        }catch (IOException e){
            return "";
        }
    }

    public static int readInt(){
        try {
            return Integer.parseInt(readLine());
        }catch (NumberFormatException e){
            return readInt();
        }
    }

    public static double readDouble(){
        try {
            return Double.parseDouble(readLine());
        }catch (NumberFormatException e){
            return readDouble();
        }
    }
}
