package objectPool;

/**
 * @author igor
 */
public class UnknownObjectException extends Exception {
    public UnknownObjectException() {
        super("The object is not in the pool");
    }
}
