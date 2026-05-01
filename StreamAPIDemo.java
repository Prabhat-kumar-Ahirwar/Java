import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " - " + salary + " - " + department;
    }
}

public class StreamAPIDemo {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 50000, "IT"),
                new Employee(2, "Ravi", 70000, "HR"),
                new Employee(3, "Neha", 60000, "IT"),
                new Employee(4, "Priya", 90000, "Finance"),
                new Employee(5, "Karan", 40000, "HR")
        );

        // 1. FILTER: Employees with salary > 50k
        System.out.println("Filtered Employees (salary > 50k):");
        employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .forEach(System.out::println);

        // 2. MAP: Get only employee names
        System.out.println("\nEmployee Names:");
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // 3. SORT: Sort by salary
        System.out.println("\nSorted by Salary:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // 4. MAX: Highest salary
        Optional<Employee> maxSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("\nHighest Salary:");
        maxSalary.ifPresent(System.out::println);

        // 5. COUNT: Number of employees in IT
        long countIT = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .count();
        System.out.println("\nNumber of IT Employees: " + countIT);

        // 6. GROUPING: Group by department
        System.out.println("\nGrouped by Department:");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        grouped.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList);
        });

        // 7. REDUCE: Total salary
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("\nTotal Salary: " + totalSalary);

        // 8. ANYMATCH: Check if any employee earns > 80k
        boolean highEarner = employees.stream()
                .anyMatch(emp -> emp.getSalary() > 80000);
        System.out.println("\nAny employee earns > 80k? " + highEarner);

        // 9. FIND FIRST
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println("\nFirst Employee:");
        first.ifPresent(System.out::println);

        // 10. DISTINCT Example
        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nUnique Departments: " + departments);
    }
}