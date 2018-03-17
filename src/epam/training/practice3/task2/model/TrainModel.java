package epam.training.practice3.task2.model;

import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;
import epam.training.practice3.task2.model.comparator.CarriageComfortComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class TrainModel<T extends Carriage> {
    private final static int START_SIZE = 10;
    private int size = 0;
    private Carriage[] train = new Carriage[START_SIZE];

    public T[] getTrain() {
        return returnArray(train);
    }

    public void setTrain(T[] train) {
        this.train = train;
        size = train.length;
    }

    public void addCarriage(Carriage carriage) {
        ensureCapacity();
        train[size++] = carriage;
    }

    private void ensureCapacity(){
        if (size + 1 > train.length){
            final int NEW_SIZE = size * 2;
            Carriage[] newTrainArray = new Carriage[NEW_SIZE];
            System.arraycopy(train, 0, newTrainArray, 0, size);
            train = newTrainArray;
        }
    }

    public long passengerAmount() {
        long passengerAmount = 0L;
        for (int i = 0; i < size; i++){
            if (train[i] instanceof PassengersCarriage){
                PassengersCarriage pc = (PassengersCarriage) train[i];
                passengerAmount = passengerAmount + pc.getAmountOfSeats();
            }
        }
        return passengerAmount;
    }

    public long luggageAmount() {
        long luggageAmount = 0L;
        for (int i = 0; i < size; i++){
            luggageAmount += train[i].getMaxLoad();
        }
        return luggageAmount;
    }

    public T[] sortCarriagesByComfort() {
        return sort(new CarriageComfortComparator());
    }

    public T[] sort(Comparator<Carriage> comparator) {
        Carriage[] sortedCarriages = cutArray(train, size);
        Arrays.sort(sortedCarriages, comparator);
        return returnArray(sortedCarriages);
    }

    public T[] filterBySeats(int min, int max) {
        return filter(new Predicate<Carriage>() {
            @Override
            public boolean test(Carriage carriage) {
                if (carriage instanceof PassengersCarriage) {
                    PassengersCarriage pc = (PassengersCarriage) carriage;
                    return pc.getAmountOfSeats() > min && pc.getAmountOfSeats() < max;
                }
                return false;
            }
        });
    }

    public T[] filter(Predicate<Carriage> predicate) {
        Carriage[] filteredTrain = new Carriage[size];
        int pos = 0;
        for (int i = 0; i < size; i++){
            Carriage carriage = train[i];
            if (predicate.test(carriage)) {
                filteredTrain[pos++] = carriage;
            }
        }
        return returnArray(filteredTrain);
    }

    private T[] returnArray(Carriage[] carriages){
        int realSize = 0;
        for (; carriages.length > realSize && carriages[realSize] != null ; realSize++);
        return (T[]) cutArray(carriages, realSize);
    }

    private Carriage[] cutArray(Carriage[] carriages, int size){
        if (size == 0)
            return new Carriage[]{};
        Carriage[] cut = new Carriage[size];
        System.arraycopy(carriages, 0, cut, 0, size);
        return cut;
    }
}