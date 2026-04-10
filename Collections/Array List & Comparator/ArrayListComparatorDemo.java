import java.util.*;

// Custom Class
class Student {
    int id;
    String name;
    int age;
    int marks;

    // Constructor
    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // toString() for printing
    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }

    // equals() and hashCode() (IMPORTANT for collections)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student s = (Student) o;
        return id == s.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class ArrayListComparatorDemo {

    public static void main(String[] args) {

        // ============================
        // 1. ARRAYLIST CREATION
        // ============================
        ArrayList<Integer> list = new ArrayList<>();

        // ============================
        // 2. ADD METHODS
        // ============================
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15); // insert at index

        System.out.println("List after add: " + list);

        // ============================
        // 3. GET & SET
        // ============================
        System.out.println("Element at index 2: " + list.get(2));

        list.set(2, 100);
        System.out.println("After set: " + list);

        // ============================
        // 4. REMOVE METHODS
        // ============================
        list.remove(1); // remove by index
        list.remove(Integer.valueOf(30)); // remove by value

        System.out.println("After remove: " + list);

        // ============================
        // 5. SIZE / CHECK
        // ============================
        System.out.println("Size: " + list.size());
        System.out.println("Contains 10? " + list.contains(10));
        System.out.println("Is Empty? " + list.isEmpty());

        // ============================
        // 6. SEARCH
        // ============================
        list.add(10);
        System.out.println("IndexOf 10: " + list.indexOf(10));
        System.out.println("LastIndexOf 10: " + list.lastIndexOf(10));

        // ============================
        // 7. ITERATION
        // ============================

        // for loop
        System.out.print("For loop: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // for-each
        System.out.print("\nFor-each: ");
        for (int x : list) {
            System.out.print(x + " ");
        }

        // Iterator (SAFE REMOVE)
        System.out.print("\nIterator remove (remove 10): ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 10)
                it.remove();
        }
        System.out.println(list);

        // ============================
        // 8. BULK OPERATIONS
        // ============================
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(100);

        list.addAll(list2);
        System.out.println("After addAll: " + list);

        list.removeAll(list2);
        System.out.println("After removeAll: " + list);

        list.addAll(list2);
        list.retainAll(list2);
        System.out.println("After retainAll: " + list);

        // ============================
        // 9. UTILITY METHODS
        // ============================
        list.clear();
        System.out.println("After clear: " + list);

        // ============================
        // 10. CUSTOM OBJECT LIST
        // ============================
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Aman", 22, 80));
        students.add(new Student(2, "Riya", 20, 90));
        students.add(new Student(3, "Kunal", 22, 85));
        students.add(new Student(4, "Neha", 21, 90));

        System.out.println("\nStudents List:");
        for (Student s : students)
            System.out.println(s);

        // ============================
        // 11. COMPARATOR (LAMBDA)
        // ============================

        // Sort by age (ascending)
        students.sort((a, b) -> a.age - b.age);

        System.out.println("\nSorted by age:");
        students.forEach(System.out::println);

        // Sort by marks (descending)
        students.sort((a, b) -> b.marks - a.marks);

        System.out.println("\nSorted by marks desc:");
        students.forEach(System.out::println);

        // ============================
        // 12. MULTI-LEVEL SORTING
        // ============================
        students.sort((a, b) -> {
            if (a.age != b.age)
                return a.age - b.age;
            return a.name.compareTo(b.name);
        });

        System.out.println("\nSorted by age then name:");
        students.forEach(System.out::println);

        // ============================
        // 13. COMPARATOR METHODS (JAVA 8)
        // ============================

        // comparing()
        students.sort(Comparator.comparing(s -> s.age));

        // thenComparing()
        students.sort(
                Comparator.comparing((Student s) -> s.marks)
                          .thenComparing(s -> s.name)
        );

        // reversed()
        students.sort(
                Comparator.comparing((Student s) -> s.marks).reversed()
        );

        System.out.println("\nComparator utility methods:");
        students.forEach(System.out::println);

        // ============================
        // 14. SORT STRINGS
        // ============================
        ArrayList<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Python");
        names.add("C");

        // sort by length
        names.sort((a, b) -> a.length() - b.length());

        System.out.println("\nSorted by length:");
        System.out.println(names);

        // ============================
        // 15. SORT MAP BY VALUE
        // ============================
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 50);
        map.put(2, 30);
        map.put(3, 70);

        List<Map.Entry<Integer, Integer>> entryList =
                new ArrayList<>(map.entrySet());

        entryList.sort((a, b) -> a.getValue() - b.getValue());

        System.out.println("\nMap sorted by value:");
        for (Map.Entry<Integer, Integer> e : entryList) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

    }
}