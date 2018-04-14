package controller.utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {
    private static Logger LOGGER = Logger.getLogger(InputUtils.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            LOGGER.error("input mechanism error", e);
            return "";
        }
    }

    public static int readInt() {

        try {
            return Integer.parseInt(readLine());
        }catch (NumberFormatException e){
            LOGGER.warn("wrong data format");
            return readInt();
        }
    }
}
