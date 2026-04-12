import java.util.*;

public class ModernStack {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        stack.pop();

        System.out.println("After pop: " + stack);
    }
}