import java.util.HashMap;
import java.util.Iterator;

class MySet<E> implements Iterable<E> {

    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    // Constructor
    public MySet() {
        map = new HashMap<>();
    }

    // Add element
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    // Remove element
    public boolean remove(E e) {
        return map.remove(e) == PRESENT;
    }

    // Check if element exists
    public boolean contains(E e) {
        return map.containsKey(e);
    }

    // Size of set
    public int size() {
        return map.size();
    }

    // Check if empty
    public boolean isEmpty() {
        return map.isEmpty();
    }

    // Clear all elements
    public void clear() {
        map.clear();
    }

    // Iterator support
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    // Convert to array
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    // Display set
    public void display() {
        for (E e : map.keySet()) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
