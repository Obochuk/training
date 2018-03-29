package epam.training.project.model.util;

import epam.training.project.model.vehicle.car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final static String FILE_NAME = "cars.ser";

    public static List<Car> readFile() throws IOException, ClassNotFoundException{
        List<Car> cars = new ArrayList<>();
        try(ObjectInput objectInput = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            while (true) {
                cars.add((Car) objectInput.readObject());
            }
        } catch (EOFException e){
            return cars;
        }
    }
}
