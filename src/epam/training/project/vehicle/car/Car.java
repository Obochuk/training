package epam.training.project.vehicle.car;

import epam.training.project.vehicle.Vehicle;
import epam.training.project.vehicle.car.engine.EngineType;
import epam.training.project.vehicle.car.fuel.FuelType;

import java.util.Map;

public abstract class Car extends Vehicle {
    private double price;
    private EngineType engineType;
    private Map<FuelType, Double> fuelConsumptions;
    private double timeTo100;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Map<FuelType, Double> getFuelConsumptions() {
        return fuelConsumptions;
    }

    public void setFuelConsumptions(Map<FuelType, Double> fuelConsumptions) {
        this.fuelConsumptions = fuelConsumptions;
    }

    public double getTimeTo100() {
        return timeTo100;
    }

    public void setTimeTo100(double timeTo100) {
        this.timeTo100 = timeTo100;
    }
}
