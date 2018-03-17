package epam.training.practice3.task2.controller.creation;

import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.model.carriage.freight.FreightCarriage;
import epam.training.practice3.task2.model.carriage.passengers.compartmental.CompartmentalCar;
import epam.training.practice3.task2.model.carriage.passengers.compartmental.LuxuryCar;
import epam.training.practice3.task2.model.carriage.passengers.compartmental.SleepingCar;
import epam.training.practice3.task2.model.carriage.passengers.ordinary.ReservedSeatsCar;
import epam.training.practice3.task2.model.carriage.passengers.ordinary.sitting.SittingFirstClassCar;
import epam.training.practice3.task2.model.carriage.passengers.ordinary.sitting.SittingSecondClassCar;
import epam.training.practice3.task2.model.carriage.passengers.ordinary.sitting.SittingThirdClassCar;

public enum CarriageType {
    FREIGHT(FreightCarriage.class), COMPARTMENTAL(CompartmentalCar.class), LUXURY(LuxuryCar.class), SLEEPING(SleepingCar.class),
    SITTING_FIRST_CLASS(SittingFirstClassCar.class), SITTING_SECOND_CLASS(SittingSecondClassCar.class),
    SITTING_THIRD_CLASS(SittingThirdClassCar.class), RESERVED_SEATS(ReservedSeatsCar.class);

    private Class<? extends Carriage> aClass;
    public final static String MENU = getMenu();

    CarriageType(Class<? extends Carriage> aClass) {
        this.aClass = aClass;
    }

    public Carriage getInstance(){
        try {
            return aClass.newInstance();
        }catch (Exception e){
            throw new InternalError("Can`t create instance");
        }
    }

    private static String getMenu(){
        StringBuilder builder = new StringBuilder();
        for (CarriageType carriageType: CarriageType.values()) {
            builder.append(carriageType.ordinal()).append(". ").append(carriageType).append("; ");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replaceAll("_", " ");
    }
}
