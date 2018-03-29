package epam.training.project.model.vehicle.car;

import epam.training.project.model.vehicle.Vehicle;
import epam.training.project.model.vehicle.car.engine.EngineType;
import epam.training.project.model.vehicle.car.fuel.FuelType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

public abstract class Car extends Vehicle implements Externalizable{
    private double price;
    private EngineType engineType;
    private Map<FuelType, Double> fuelConsumptions;
    private double timeTo100;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0)
            throw new IllegalArgumentException("Price of car cannot be negative");
        this.price = price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) throws NullPointerException {
        if (engineType == null)
            throw new NullPointerException();
        this.engineType = engineType;
    }

    public Map<FuelType, Double> getFuelConsumptions() {
        return fuelConsumptions;
    }

    public void setFuelConsumptions(Map<FuelType, Double> fuelConsumptions) throws IllegalArgumentException, NullPointerException {
        if (fuelConsumptions == null)
            throw new NullPointerException();
        if (fuelConsumptions.size() == 0)
            throw new IllegalArgumentException("Car must have some fule consumption");
        this.fuelConsumptions = fuelConsumptions;
    }

    public double getTimeTo100() {
        return timeTo100;
    }

    public void setTimeTo100(double timeTo100) throws IllegalArgumentException {
        if (timeTo100 < 0)
            throw new IllegalArgumentException("Time cannot be negative");
        this.timeTo100 = timeTo100;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append("{").append("Price: ").append(price);
        builder.append(", passangers: ").append(getMaxPassengerAmount());
        builder.append(", speed: ").append(getMaxSpeed());
        builder.append(", fuel consumption: ").append(fuelConsumptions).append('}');
        return builder.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getMaxPassengerAmount());
        out.writeDouble(getMaxSpeed());
        out.writeDouble(getMaxCargoCapacity());
        out.writeDouble(price);
        out.writeObject(engineType);
        out.writeObject(fuelConsumptions);
        out.writeDouble(timeTo100);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setMaxPassengerAmount(in.readInt());
        setMaxSpeed(in.readDouble());
        setMaxCargoCapacity(in.readDouble());
        price = in.readDouble();
        engineType = (EngineType) in.readObject();
        fuelConsumptions = (Map<FuelType, Double>) in.readObject();
        timeTo100 = in.readDouble();
    }
}
