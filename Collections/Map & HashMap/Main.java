public class Main {
    public static void main(String[] args) {

        MySet<Integer> set = new MySet<>();

        // Add
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // duplicate

        System.out.print("Set elements: ");
        set.display();

        // Contains
        System.out.println("Contains 20: " + set.contains(20));

        // Remove
        set.remove(20);
        System.out.print("After removing 20: ");
        set.display();

        // Size
        System.out.println("Size: " + set.size());

        // isEmpty
        System.out.println("Is Empty: " + set.isEmpty());

        // Iterator
        System.out.print("Using Iterator: ");
        for (int x : set) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Clear
        set.clear();
        System.out.println("After clear, isEmpty: " + set.isEmpty());
    }
}
