package epam.training.practice3.task2.view;

import epam.training.practice3.task2.model.carriage.Carriage;

import java.util.List;

public class TrainView {
    public void showMessage(String message){
        System.out.println(message);
    }

    public void showMessageAndResult(String message, String result){
        System.out.println(message + ' ' + result);
    }

    public String toString(List<? extends Carriage> carriages){
        StringBuilder builder = new StringBuilder();
        for (Carriage carriage : carriages) {
            builder.append(carriage.toString()).append('\n');
        }
        return builder.toString();
    }
}
