import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {

        // ============================
        // 1. CREATE LINKEDLIST
        // ============================
        LinkedList<Integer> list = new LinkedList<>();

        // ============================
        // 2. ADD METHODS
        // ============================
        list.add(10);
        list.add(20);
        list.add(30);

        list.addFirst(5);     // add at beginning
        list.addLast(40);     // add at end
        list.add(2, 15);      // add at index

        System.out.println("After adding: " + list);

        // ============================
        // 3. ACCESS METHODS
        // ============================
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        // ============================
        // 4. REMOVE METHODS
        // ============================
        list.remove();          // remove first
        list.removeFirst();     // remove first
        list.removeLast();      // remove last
        list.remove(1);         // remove by index
        list.remove(Integer.valueOf(20)); // remove by value

        System.out.println("After removal: " + list);

        // ============================
        // 5. SEARCH METHODS
        // ============================
        list.add(50);
        list.add(50);

        System.out.println("Contains 50? " + list.contains(50));
        System.out.println("IndexOf 50: " + list.indexOf(50));
        System.out.println("LastIndexOf 50: " + list.lastIndexOf(50));

        // ============================
        // 6. ITERATION
        // ============================

        // for-each
        System.out.print("For-each: ");
        for (int x : list) {
            System.out.print(x + " ");
        }

        // Iterator
        System.out.print("\nIterator: ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // ============================
        // 7. DEQUE / QUEUE METHODS
        // ============================
        list.offer(100);   // add at end
        list.offerFirst(1);
        list.offerLast(200);

        System.out.println("\nAfter offer: " + list);

        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());

        System.out.println("After poll: " + list);

        // ============================
        // 8. BULK OPERATIONS
        // ============================
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(10);

        list.addAll(list2);
        System.out.println("After addAll: " + list);

        list.removeAll(list2);
        System.out.println("After removeAll: " + list);

        list.addAll(list2);
        list.retainAll(list2);
        System.out.println("After retainAll: " + list);

        // ============================
        // 9. CLEAR
        // ============================
        list.clear();
        System.out.println("After clear: " + list);
    }
}