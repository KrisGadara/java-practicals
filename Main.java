import java.util.Scanner;

class Member {
    public String name;
    public int age;
    public long pn;
    public double salary;
    public String add;

    void printSalary() {
        System.out.println("Salary of " + name + ": " + salary);
    }
}

class Employee extends Member {
    String specialization;
}

class Manager extends Member {
    String department;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee emp = new Employee();
        System.out.println("Enter name:");
        emp.name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        emp.age = scanner.nextInt();
        System.out.print("Enter employee salary: ");
        emp.salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter employee specialization: ");
        emp.specialization = scanner.nextLine();

        emp.printSalary();
        System.out.println("Specialization: " + emp.specialization);

        Manager mgr = new Manager();
        System.out.print("\nEnter manager name: ");
        mgr.name = scanner.nextLine();
        System.out.print("Enter manager age: ");
        mgr.age = scanner.nextInt();
        System.out.print("Enter manager salary: ");
        mgr.salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter manager department: ");
        mgr.department = scanner.nextLine();

        mgr.printSalary();
        System.out.println("Department: " + mgr.department);

        scanner.close();
    }
}
