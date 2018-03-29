package epam.training.project.model.vehicle.car.comparator;

import epam.training.project.model.vehicle.car.Car;
import epam.training.project.model.vehicle.car.fuel.FuelType;

import java.util.Comparator;
import java.util.Map;

public class CarFuelConsumptionComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        Map<FuelType, Double> firstCarConsumptions =  o1.getFuelConsumptions();
        Map<FuelType, Double> secondCarConsumptions = o2.getFuelConsumptions();

        double firewoodConsumption1 = getFirewoodConsumption(firstCarConsumptions);
        double firewoodConsumption2 = getFirewoodConsumption(secondCarConsumptions);

        if (firewoodConsumption1 != firewoodConsumption2){
            return Double.compare(firewoodConsumption1, firewoodConsumption2);
        }else {
            double electricityConsumption1 = getElectricityConsumption(firstCarConsumptions);
            double electricityConsumption2 = getElectricityConsumption(secondCarConsumptions);
            return Double.compare(electricityConsumption1, electricityConsumption2);
        }
    }

    private double getFirewoodConsumption(Map<FuelType, Double> fuelConsumptions){
        if (fuelConsumptions.containsKey(FuelType.GAS)) {
            return fuelConsumptions.get(FuelType.GAS);
        }
        else if (fuelConsumptions.containsKey(FuelType.DIESEL)) {
            return fuelConsumptions.get(FuelType.DIESEL);
        }
        return 0;
    }

    private double getElectricityConsumption(Map<FuelType, Double> fuelConsumptions){
        return fuelConsumptions.getOrDefault(FuelType.ELECTRICITY, 0.0);
    }
}
