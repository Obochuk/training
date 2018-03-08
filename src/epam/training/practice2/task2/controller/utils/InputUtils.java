package epam.training.practice2.task2.controller.utils;

import epam.training.practice2.task2.view.LibraryView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static int readInt() {
        return Integer.parseInt(readLine());
    }
}
