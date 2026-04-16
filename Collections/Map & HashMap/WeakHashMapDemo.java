import java.util.*;

public class WeakHashMapDemo {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new WeakHashMap<>();

        String key1 = new String("A");
        String key2 = new String("B");

        map.put(key1, "Apple");
        map.put(key2, "Ball");

        System.out.println("Before GC: " + map);

        // Remove strong reference
        key1 = null;

        // Suggest garbage collection
        System.gc();

        Thread.sleep(1000);

        System.out.println("After GC: " + map);
    }
}
