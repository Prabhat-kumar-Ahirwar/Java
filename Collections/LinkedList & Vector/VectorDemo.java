import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        // ============================
        // 1. CREATE VECTOR
        // ============================
        Vector<Integer> vec = new Vector<>();

        // ============================
        // 2. ADD METHODS
        // ============================
        vec.add(10);
        vec.add(20);
        vec.add(30);

        vec.add(1, 15); // insert at index

        // Legacy methods
        vec.addElement(40);

        System.out.println("After adding: " + vec);

        // ============================
        // 3. ACCESS METHODS
        // ============================
        System.out.println("Element at index 2: " + vec.get(2));
        System.out.println("First element: " + vec.firstElement());
        System.out.println("Last element: " + vec.lastElement());

        // ============================
        // 4. REMOVE METHODS
        // ============================
        vec.remove(1); // remove by index
        vec.remove(Integer.valueOf(30)); // remove by value

        // Legacy remove
        vec.removeElement(40);

        System.out.println("After removal: " + vec);

        // ============================
        // 5. SEARCH METHODS
        // ============================
        vec.add(50);
        vec.add(50);

        System.out.println("Contains 50? " + vec.contains(50));
        System.out.println("IndexOf 50: " + vec.indexOf(50));
        System.out.println("LastIndexOf 50: " + vec.lastIndexOf(50));

        // ============================
        // 6. ITERATION
        // ============================

        // for loop
        System.out.print("For loop: ");
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }

        // Enumeration (Legacy)
        System.out.print("\nEnumeration: ");
        Enumeration<Integer> e = vec.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }

        // ============================
        // 7. BULK OPERATIONS
        // ============================
        Vector<Integer> vec2 = new Vector<>();
        vec2.add(5);
        vec2.add(10);

        vec.addAll(vec2);
        System.out.println("\nAfter addAll: " + vec);

        vec.removeAll(vec2);
        System.out.println("After removeAll: " + vec);

        vec.addAll(vec2);
        vec.retainAll(vec2);
        System.out.println("After retainAll: " + vec);

        // ============================
        // 8. CAPACITY METHODS
        // ============================
        System.out.println("Capacity: " + vec.capacity());
        vec.ensureCapacity(20);
        System.out.println("After ensureCapacity: " + vec.capacity());

        vec.trimToSize();
        System.out.println("After trimToSize: " + vec.capacity());

        // ============================
        // 9. CLEAR
        // ============================
        vec.clear();
        System.out.println("After clear: " + vec);
    }
}