import java.util.*;

// Custom class for equals() & hashCode()
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student s = (Student) o;
        return this.id == s.id;
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class MapHashMapFullDemo {

    public static void main(String[] args) {

        // ============================
        // 1. CREATE MAP
        // ============================
        Map<Integer, String> map = new HashMap<>();

        // ============================
        // 2. PUT METHODS
        // ============================
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");

        // Duplicate key (overwrites value)
        map.put(2, "JavaScript");

        // Null key & value
        map.put(null, "NullKey");
        map.put(4, null);

        System.out.println("Map: " + map);

        // ============================
        // 3. GET METHODS
        // ============================
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Contains key 3? " + map.containsKey(3));
        System.out.println("Contains value Java? " + map.containsValue("Java"));

        // ============================
        // 4. REMOVE METHODS
        // ============================
        map.remove(3);
        System.out.println("After remove key 3: " + map);

        // ============================
        // 5. SIZE & CHECK
        // ============================
        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());

        // ============================
        // 6. ITERATION METHODS
        // ============================

        // keySet()
        System.out.println("\nUsing keySet:");
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // values()
        System.out.println("\nValues:");
        for (String val : map.values()) {
            System.out.println(val);
        }

        // entrySet() (BEST METHOD)
        System.out.println("\nUsing entrySet:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ============================
        // 7. CUSTOM OBJECT AS KEY
        // ============================
        Map<Student, String> studentMap = new HashMap<>();

        Student s1 = new Student(1, "Aman");
        Student s2 = new Student(1, "Aman"); // same id

        studentMap.put(s1, "First");
        studentMap.put(s2, "Second"); // replaces due to equals()

        System.out.println("\nCustom Object Map:");
        for (Map.Entry<Student, String> e : studentMap.entrySet()) {
            System.out.println(e.getKey().id + " -> " + e.getValue());
        }

        // ============================
        // 8. SORT MAP BY KEY
        // ============================
        TreeMap<Integer, String> sortedByKey = new TreeMap<>(map);

        System.out.println("\nSorted by Key:");
        System.out.println(sortedByKey);

        // ============================
        // 9. SORT MAP BY VALUE
        // ============================
        List<Map.Entry<Integer, String>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (a.getValue() == null) return -1;
            if (b.getValue() == null) return 1;
            return a.getValue().compareTo(b.getValue());
        });

        System.out.println("\nSorted by Value:");
        for (Map.Entry<Integer, String> e : list) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // ============================
        // 10. FREQUENCY COUNT (IMPORTANT)
        // ============================
        int[] arr = {1, 2, 2, 3, 3, 3};

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("\nFrequency Map:");
        System.out.println(freq);

        // ============================
        // 11. FAIL-FAST EXAMPLE
        // ============================
        try {
            for (Integer key : map.keySet()) {
                map.remove(key); // ❌ Exception
            }
        } catch (Exception e) {
            System.out.println("\nFail-Fast Exception: " + e);
        }

        // ============================
        // 12. SAFE REMOVE USING ITERATOR
        // ============================
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            if (e.getKey() != null) {
                it.remove(); // safe removal
            }
        }

        System.out.println("\nAfter safe removal: " + map);
    }
}