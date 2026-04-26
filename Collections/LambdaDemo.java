// Functional Interface
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

// Another Functional Interface
@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

public class LambdaDemo {

    public static void main(String[] args) {

        // 1. Lambda for Addition
        Calculator add = (a, b) -> a + b;
        System.out.println("Addition: " + add.operate(10, 5));

        // 2. Lambda for Multiplication
        Calculator multiply = (a, b) -> a * b;
        System.out.println("Multiplication: " + multiply.operate(10, 5));

        // 3. Lambda with multi-line logic
        Calculator complex = (a, b) -> {
            int result = a * b;
            result = result + 10;
            return result;
        };
        System.out.println("Complex Operation: " + complex.operate(2, 3));

        // 4. Lambda for printing message
        MessagePrinter printer = msg -> System.out.println("Message: " + msg);
        printer.print("Hello Lambda");

        // 5. Passing Lambda as Argument (IMPORTANT)
        printResult(20, 10, (a, b) -> a - b); // subtraction
        printResult(20, 10, (a, b) -> a / b); // division
    }

    // Method that accepts lambda (functional interface)
    public static void printResult(int a, int b, Calculator operation) {
        int result = operation.operate(a, b);
        System.out.println("Result: " + result);
    }
}
