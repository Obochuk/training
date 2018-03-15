package epam.training.practice3.task1.shop.user.authentication;

public class IllegalAuthenticationTokenException extends RuntimeException {
    public IllegalAuthenticationTokenException(String message) {
        super(message);
    }
}
