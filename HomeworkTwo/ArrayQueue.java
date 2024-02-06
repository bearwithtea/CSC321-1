
import java.util.ArrayList;
import java.util.Queue;

/**
 * Array implementation of a queue.
 * @author davereed
 * @version 12/28/23
 */
public class ArrayQueue<T> extends ArrayList<T> implements Queue<T> {
    public boolean add(T item) {
        if (!super.add(item)) {
            throw (new IllegalStateException());
        }
        return true;
    }
    
    public boolean offer(T item) {
        return super.add(item);
    }
    
    public T remove() {
        if (this.isEmpty()) {
            throw (new java.util.NoSuchElementException());
        }    
        return super.remove(0);
    }
    
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }
        return super.remove(0);
    }
    
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.get(0);
    }
    
    public T element() {
        if (this.isEmpty()) {
            throw (new java.util.NoSuchElementException());
        }
        return this.get(0);
    }
}