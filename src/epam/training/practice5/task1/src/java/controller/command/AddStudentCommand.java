package controller.command;

import controller.command.constants.RegexExpressions;
import controller.utils.InputUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import model.RegisterModel;
import model.Student;
import model.exception.WrongFormatException;
import view.View;
import view.constants.Messages;

import java.util.function.Consumer;
import java.util.regex.Pattern;

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

    }

    private void inputLastName(Student student, View view){

    }

    private void inputBirthDate(Student student, View view){

    }

    private void inputPhone(Student student, View view){

    }

    private void inputAddress(Student student, View view){

    }


}

