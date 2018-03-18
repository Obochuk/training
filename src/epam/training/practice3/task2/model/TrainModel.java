package epam.training.practice3.task2.model;

import epam.training.practice3.task2.model.carriage.Carriage;
import epam.training.practice3.task2.model.carriage.passengers.PassengersCarriage;
import epam.training.practice3.task2.model.comparator.CarriageComfortComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TrainModel<T extends Carriage> {
    private final Class<T> thisClass;
    private List<T> train = new ArrayList<T>();

    public TrainModel(Class<T> thisClass) {
        this.thisClass = thisClass;
    }

    public List<T> getTrain() {
        return train;
    }

    public void setTrain(List<T> train) {
        this.train = train;
    }

    public void addCarriage(Carriage carriage) {
        if (thisClass.isAssignableFrom(carriage.getClass())) {
            train.add(thisClass.cast(carriage));
        }
        else {
            throw new ClassCastException();
        }
    }

    public long passengerAmount() {
        long passengerAmount = 0L;
        for (T carriage: train){
            if (carriage instanceof PassengersCarriage){
                PassengersCarriage pc = (PassengersCarriage) carriage;
                passengerAmount = passengerAmount + pc.getAmountOfSeats();
            }
        }
        return passengerAmount;
    }

    public long luggageAmount() {
        long luggageAmount = 0L;
        for (T carriage: train){
            luggageAmount += carriage.getMaxLoad();
        }
        return luggageAmount;
    }

    public List<T> sortCarriagesByComfort() {
        return sort(new CarriageComfortComparator());
    }

    public List<T> sort(Comparator<Carriage> comparator) {
        train.sort(comparator);
        return train;
    }

    public List<T> filterBySeats(int min, int max) {
        return filter(new Predicate<T>() {
            @Override
            public boolean test(T carriage) {
                if (carriage instanceof PassengersCarriage) {
                    PassengersCarriage pc = (PassengersCarriage) carriage;
                    return pc.getAmountOfSeats() > min && pc.getAmountOfSeats() < max;
                }
                return false;
            }
        });
    }

    public List<T> filter(Predicate<T> predicate) {
        List<T> filteredTrain = new ArrayList<T>();
        for (T carriage: train){
            if (predicate.test(carriage)) {
                filteredTrain.add(carriage);
            }
        }
        return filteredTrain;
    }
}