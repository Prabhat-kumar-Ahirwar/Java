import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        // Thread 1 (reading)
        Thread t1 = new Thread(() -> {
            for (Integer num : list) {
                System.out.println("Reading: " + num);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        });

        // Thread 2 (modifying)
        Thread t2 = new Thread(() -> {
            list.add(40);  // safe modification
            System.out.println("Added 40");
        });

        t1.start();
        t2.start();
    }
}