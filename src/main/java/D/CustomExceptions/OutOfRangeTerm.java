package CustomExceptions;

public class OutOfRangeTerm extends RuntimeException{
    public OutOfRangeTerm() {
    }

    public OutOfRangeTerm(String message) {
        super(message);
    }

    public OutOfRangeTerm(String message, Throwable cause) {
        super(message, cause);
    }
}
