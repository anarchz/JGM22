package exception;

public class AccountException extends Exception {
    public AccountException(String message, Throwable err) {
        super(message, err);
    }
}
