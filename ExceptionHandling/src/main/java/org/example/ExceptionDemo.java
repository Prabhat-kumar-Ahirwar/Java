package org.example;
import java.io.*;

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    // Method using throws
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above!");
        } else {
            System.out.println("You are eligible to vote.");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Exception Handling Demo ===");

        // 1. Arithmetic Exception
        try {
            int a = 10, b = 0;
            int result = a / b; // will throw exception
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        // 2. Array Index Exception
        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }

        // 3. Multiple Catch
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        } catch (Exception e) {
            System.out.println("General Exception caught");
        }

        // 4. Nested Try
        try {
            try {
                int x = 100 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Division by zero");
            }

            int arr[] = new int[2];
            arr[5] = 10; // outer exception

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Array index issue");
        }

        // 5. Custom Exception
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }

        // 6. File Handling Exception
        try {
            FileReader file = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IO Exception occurred");
        } finally {
            System.out.println("Finally block always executes");
        }

        System.out.println("=== Program End ===");
    }
}