package utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {
    private final static Logger LOGGER = Logger.getLogger(InputUtils.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){
        try {
            return reader.readLine();
        } catch (IOException e){
            LOGGER.error("Can't read line", e);
            return "";
        }
    }

    public static int readInt(){
        try{
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e){
            LOGGER.error("Wrong data format, expected integer number", e );
            return readInt();
        }
    }
}
