package employee_management_portal.exception;

public class RateLimitExceedException extends RuntimeException {
    public RateLimitExceedException(String message){
        super(message);
    }
}
