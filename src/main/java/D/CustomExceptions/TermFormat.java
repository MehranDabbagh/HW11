package CustomExceptions;

public class TermFormat extends RuntimeException{
    public TermFormat() {
    }

    public TermFormat(String message) {
        super(message);
    }

    public TermFormat(String message, Throwable cause) {
        super(message, cause);
    }
}
