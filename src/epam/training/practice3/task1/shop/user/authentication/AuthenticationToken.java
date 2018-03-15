package epam.training.practice3.task1.shop.user.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AuthenticationToken {
    private byte[] digest;

    public AuthenticationToken(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            digest = md.digest();

        } catch (NoSuchAlgorithmException e) {
            digest = null;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj.getClass() != getClass())
            return false;
        AuthenticationToken o = (AuthenticationToken) obj;
        return Arrays.equals(digest, o.digest);
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException();
    }
}
