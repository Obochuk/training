package shop.user.authentication;

public class IllegalAuthenticationTokenException extends RuntimeException {
    public IllegalAuthenticationTokenException(String message) {
        super(message);
    }
}
