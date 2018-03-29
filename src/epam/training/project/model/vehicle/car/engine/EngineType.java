package epam.training.project.model.vehicle.car.engine;

import epam.training.project.model.vehicle.car.fuel.FuelType;

public enum EngineType {
    GAS(FuelType.GAS), DIESEL(FuelType.DIESEL), ELECTRIC(FuelType.ELECTRICITY),
    HYBRID(FuelType.GAS, FuelType.ELECTRICITY);

    private FuelType[] usedFuelTypes;

    EngineType(FuelType ... usedFuelTypes){
        this.usedFuelTypes = usedFuelTypes;
    }

    public FuelType[] getUsedFuelTypes() {
        return usedFuelTypes;
    }
}
