package epam.training.project.model;

import epam.training.project.model.util.FileReader;
import epam.training.project.model.vehicle.car.Car;
import epam.training.project.model.vehicle.car.comparator.CarFuelConsumptionComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TaxiModel {
    private List<Car> cars;

    public TaxiModel(){
        try {
            cars = FileReader.readFile();
        } catch (IOException e){
            System.out.println("Model cannot be properly initialized");
        } catch (ClassNotFoundException e){
            System.out.println("There are not class needed to read the file. Model cannot be properly initialized");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public double getPrice(){
        double price = 0;
        for (Car car: cars)
            price += car.getPrice();
        return price;
    }

    public List<Car> sortByFuelConsumption(){
        return sort(new CarFuelConsumptionComparator());
    }

    public List<Car> sort(Comparator<Car> carComparator){
        cars.sort(carComparator);
        return Collections.unmodifiableList(cars);
    }

    public List<Car> filterBySpeed(double min, double max){
        return filter((car) -> (car.getMaxSpeed() >= min && car.getMaxSpeed() <= max));
    }

    public List<Car> filter(Predicate<Car> carPredicate){
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car))
                filteredCars.add(car);
        }
        return filteredCars;
    }
}
