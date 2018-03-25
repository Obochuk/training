package controller.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static int readInt(){
        String input = readString();
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            return readInt();
        }
    }
}
