package objectPool;

import java.util.ArrayList;

/**
 * @author igor
 */
public class ObjectPool<T> {
    private ArrayList<T> objects;
    private ArrayList<Boolean> locked;

    public ObjectPool(ArrayList<T> objects) {
        this.objects = objects;
        this.locked = new ArrayList<Boolean>(objects.size());
    }

    public ObjectPool(int size) {
        this(new ArrayList<T>(size));
    }

    public ObjectPool() {
        this(new ArrayList<T>());
    }

    public synchronized void add(T object) {
        objects.add(object);
        locked.add(false);
    }

    public synchronized T get() throws NoUnlockedObjectException {
        for (int i = 0; i < locked.size(); i++) {
            if (!locked.get(i)) {
                locked.set(i, true);
                return objects.get(i);
            }
        }
        throw new NoUnlockedObjectException();
    }

    public synchronized void release(T object) throws UnknownObjectException {
        int i = objects.indexOf(object);

        if (i < 0)
            throw new UnknownObjectException();

        locked.set(i, false);
    }
}
