package objectPool;

/**
 * @author igor
 */
public class NoUnlockedObjectException extends Exception {
    public NoUnlockedObjectException() {
        super("No free object available");
    }
}
