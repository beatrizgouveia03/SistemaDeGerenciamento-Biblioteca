package Exception;

public class EntityNotFoundException extends DatabaseException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
        super(message);
    }
}
