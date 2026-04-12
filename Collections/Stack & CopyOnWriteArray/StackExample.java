import java.util.*;

public class StackExample {

    // Function to check valid parentheses
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // if stack empty → invalid
                if (st.isEmpty()) return false;

                char top = st.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "{[()]}";
        String s2 = "{[(])}";

        System.out.println("Valid? " + isValid(s1)); // true
        System.out.println("Valid? " + isValid(s2)); // false

        // Basic Stack operations
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top: " + st.peek());
        st.pop();
        System.out.println("After pop: " + st);
    }
}