package by.epam.web.unit2.exception;

public class DataValidatorException extends Exception {
    private static final long serialVersionUID = 1L;

    public DataValidatorException() {
        super();
    }

    public DataValidatorException(String message) {
        super(message);
    }

    public DataValidatorException(Exception e) {
        super(e);
    }

    public DataValidatorException(String message, Exception e) {
        super(message, e);
    }
}
