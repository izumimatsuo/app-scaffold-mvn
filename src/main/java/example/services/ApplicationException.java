package example.services;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }
    
    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
