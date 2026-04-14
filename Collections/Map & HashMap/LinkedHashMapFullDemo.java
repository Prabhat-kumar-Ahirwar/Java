import java.util.*;

public class LinkedHashMapFullDemo {

    // 🔹 LRU Cache using LinkedHashMap
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true); // access-order = true
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

        // 🔹 1. Insertion Order
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Apple");
        map.put(3, "Mango");
        map.put(2, "Banana");

        System.out.println("Insertion Order:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 🔹 2. Access Order
        LinkedHashMap<Integer, String> accessMap =
                new LinkedHashMap<>(16, 0.75f, true);

        accessMap.put(1, "A");
        accessMap.put(2, "B");
        accessMap.put(3, "C");

        accessMap.get(1); // access 1
        accessMap.get(2); // access 2

        System.out.println("\nAccess Order:");
        for (Map.Entry<Integer, String> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 🔹 3. LRU Cache
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1); // use 1
        cache.put(4, "D"); // removes least recently used

        System.out.println("\nLRU Cache:");
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}