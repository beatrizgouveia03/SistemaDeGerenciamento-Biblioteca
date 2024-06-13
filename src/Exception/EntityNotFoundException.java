package Exception;

public class EntityNotFoundException extends DatabaseException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
