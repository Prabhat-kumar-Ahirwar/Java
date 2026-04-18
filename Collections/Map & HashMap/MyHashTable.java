import java.util.LinkedList;

public class MyHashTable<K, V> {

    // Node (key-value pair)
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // number of elements
    private int capacity; // bucket size
    private LinkedList<Node>[] buckets;

    // Constructor
    public MyHashTable() {
        capacity = 4;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash Function
    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Search key in bucket
    private int searchInBucket(K key, int bucketIndex) {
        LinkedList<Node> bucket = buckets[bucketIndex];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // PUT (Insert / Update)
    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex == -1) {
            buckets[bucketIndex].add(new Node(key, value));
            size++;
        } else {
            buckets[bucketIndex].get(dataIndex).value = value;
        }

        double loadFactor = (double) size / capacity;
        if (loadFactor > 2.0) {
            rehash();
        }
    }

    // GET (Search)
    public V get(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            return buckets[bucketIndex].get(dataIndex).value;
        }
    }

    // CONTAINS KEY
    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);
        return dataIndex != -1;
    }

    // REMOVE
    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInBucket(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            Node node = buckets[bucketIndex].remove(dataIndex);
            size--;
            return node.value;
        }
    }

    // SIZE
    public int size() {
        return size;
    }

    // REHASHING (Resize)
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        capacity = capacity * 2;

        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;

        for (LinkedList<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    // DISPLAY
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + " : ");
            for (Node node : buckets[i]) {
                System.out.print("(" + node.key + "," + node.value + ") ");
            }
            System.out.println();
        }
    }

    // MAIN METHOD (TESTING)
    public static void main(String[] args) {
        MyHashTable<String, Integer> map = new MyHashTable<>();

        map.put("India", 100);
        map.put("USA", 200);
        map.put("China", 300);
        map.put("UK", 400);

        System.out.println("Get India: " + map.get("India"));

        map.put("India", 500); // update
        System.out.println("Updated India: " + map.get("India"));

        System.out.println("Contains USA: " + map.containsKey("USA"));

        map.remove("China");

        System.out.println("Size: " + map.size());

        map.display();
    }
}
