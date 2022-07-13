package zadanie02;

import java.util.function.Supplier;

public class InvalidPeselException extends IllegalStateException {
    public InvalidPeselException(String message) {
        super(message);
    }
}
