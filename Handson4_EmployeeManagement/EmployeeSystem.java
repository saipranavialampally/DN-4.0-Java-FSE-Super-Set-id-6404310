package Handson4_EmployeeManagement;

class Employee {
    int employeeId;
    String name, position;
    double salary;

    Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeSystem {
    static Employee[] employees = new Employee[100];
    static int count = 0;

    static void addEmployee(Employee emp) {
        employees[count++] = emp;
    }

    static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                return;
            }
        }
    }

    static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].employeeId + " " + employees[i].name);
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Pranavi", "Manager", 60000));
        addEmployee(new Employee(2, "Tanu", "Developer", 30000));
        addEmployee(new Employee(3, "Anu", "Tester", 25000));

        System.out.println("All Employees:");
        traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee e = searchEmployee(2);
        System.out.println(e != null ? e.name : "Not found");

        deleteEmployee(2);
        System.out.println("\nAfter deletion:");
        traverseEmployees();
    }
}
