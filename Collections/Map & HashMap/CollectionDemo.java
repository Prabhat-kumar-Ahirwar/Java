import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {

        // =======================
        // 1. LIST (ArrayList)
        // =======================
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Apple"); // duplicate allowed

        System.out.println("List Elements:");
        for (String item : list) {
            System.out.println(item);
        }

        // =======================
        // 2. SET (HashSet)
        // =======================
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // duplicate NOT allowed

        System.out.println("\nSet Elements:");
        for (String item : set) {
            System.out.println(item);
        }

        // =======================
        // 3. MAP (HashMap)
        // =======================
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Prabhat");
        map.put(2, "Rahul");
        map.put(3, "Amit");

        System.out.println("\nMap Elements:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // =======================
        // 4. Iterator Example
        // =======================
        System.out.println("\nIterator Example (List):");
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // =======================
        // 5. Sorting List
        // =======================
        Collections.sort(list);

        System.out.println("\nSorted List:");
        System.out.println(list);

        // =======================
        // 6. Queue (LinkedList)
        // =======================
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("\nQueue:");
        System.out.println(queue);

        System.out.println("Removed from queue: " + queue.poll());

        System.out.println("Queue after removal:");
        System.out.println(queue);
    }
}
