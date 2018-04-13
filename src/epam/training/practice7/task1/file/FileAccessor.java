package file;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccessor {
    private static Logger LOGGER = Logger.getLogger(FileAccessor.class);

    public static List readObjectsFromFile(String fileName, Class clazz) throws FileNotFoundException{
        try(ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return readAllObjects(objectInput, clazz);
        } catch (FileNotFoundException e){
            throw e;
        } catch (IOException e){
            LOGGER.error("cannot access specified file", e);
        }catch (ClassNotFoundException e){
            LOGGER.error("In specified file class of a specified object cannot be found", e);
        }
        return new ArrayList<>();
    }

    private static List readAllObjects(ObjectInputStream objectInputStream, Class clazz)
            throws IOException, ClassNotFoundException{
        List objects = new ArrayList<>();
        while (true){
            try {
                objects.add(clazz.cast(objectInputStream.readObject()));
            } catch (EOFException e){
                return objects;
            }
        }
    }

    public static void writeObjectsToFile(List<?> objects, String fileName) throws IOException{
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            for (Object o: objects) {
                outputStream.writeObject(o);
            }
        }
    }
}
