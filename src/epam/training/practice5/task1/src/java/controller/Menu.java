package controller;

import controller.command.AddStudentCommand;
import controller.command.Command;
import controller.command.ExitCommand;
import controller.command.OutputResultsCommand;
import model.RegisterModel;
import view.View;

public enum Menu {
    ADD_STUDENT(new AddStudentCommand(), "add new student"),
    SHOW_STUDENTS(new OutputResultsCommand(), "output all students"),
    EXIT(new ExitCommand(), "exit");

    private Command command;
    private String message;

    Menu(Command command, String message) {
        this.command = command;
        this.message = message;
    }

    public void execute(RegisterModel model, View view){
        command.execute(model, view);
    }

    public static String MENU = generateMenu();

    private static String generateMenu(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values().length; i++) {
            builder.append(i).append(") ");
            builder.append(values()[i].message).append("\n");
        }
        return builder.toString();
    }
}
