package controller.command;

import controller.utils.InputUtils;
import model.RegisterModel;
import model.Student;
import model.exception.WrongFormatException;
import view.View;
import view.constants.Messages;

public class AddStudentCommand implements Command {
    @Override
    public void execute(RegisterModel model, View view) {
        Student student = new Student();
        inputFirstName(student, view);
        inputLastName(student, view);
        inputBirthDate(student, view);
        inputPhone(student, view);
        inputAddress(student, view);
        model.addStudent(student);
    }

    private void inputFirstName(Student student, View view){
        input(view, () -> {
            view.printMessage(Messages.FIRST_NAME);
            student.setFirstName(InputUtils.readString());
        });
    }

    private void inputLastName(Student student, View view){
        input(view, () ->{
            view.printMessage(Messages.LAST_NAME);
            student.setLastName(InputUtils.readString());
        });
    }

    private void inputBirthDate(Student student, View view){
        input(view, () ->{
            view.printMessage(Messages.BIRTH_DATE);
            student.setBirthDay(InputUtils.readString());
        });
    }

    private void inputPhone(Student student, View view){
        input(view, () -> {
            view.printMessage(Messages.PHONE);
            student.setPhone(InputUtils.readString());
        });
    }

    private void inputAddress(Student student, View view){
        input(view, () -> {
            view.printMessage(Messages.ADDRESS);
            student.setAddress(InputUtils.readString());
        });
    }

    private void input(View view, ConsumerWithException consumer){
        while (true){
            try {
                consumer.apply();
                return;
            }catch (WrongFormatException e){
                view.printMessage(Messages.WRONG_FORMAT);
                view.printMessageNL(e.getMessage());
                view.printMessageNL(Messages.TRY_AGAIN);
            }
        }
    }
}

@FunctionalInterface
interface ConsumerWithException {
    void apply() throws WrongFormatException;
}
