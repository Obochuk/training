package model.exception;

public class WrongFormatException extends Exception {
    private String message;

    public WrongFormatException(){}

    public WrongFormatException(String message){
        super(message);
    }
}
