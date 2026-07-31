// Assignment Question:
// Create a Java program named 'EmployeeRecord' that manages employee details and performs basic calculations. The program should have the following functionalities:
- A class named 'Employee' to store and display employee details: name (String), age (int), salary (double) and experience (int) years.
- A method to calculate employee's bonus based on experience: if experience is between 1-5 years, bonus is 5% of salary; if experience is between 6-15 years, bonus is 7.5% of salary; if experience is more than 15 years, bonus is 10% of salary.
- A method to calculate employee's total earnings (salary + bonus).
- A main method to create an array of 'Employee' objects and perform a set of operations: display total number of employees, display employee details, display bonus and total earnings for each employee, and display the average bonus and total earnings of all employees.
// Author: Ansh Pandey

import java.util.Scanner;

public class EmployeeRecord {
    public static class Employee {
        String name;
        int age;
        double salary;
        int experience;

        public Employee(String name, int age, double salary, int experience) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.experience = experience;
        }

        public double calculateBonus() {
            if (experience >= 1 && experience <= 5) {
                return salary * 0.05;
            } else if (experience >= 6 && experience <= 15) {
                return salary * 0.075;
            } else {
                return salary * 0.10;
            }
        }

        public double calculateTotalEarnings() {
            return salary + calculateBonus();
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter employee " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline left-over

            System.out.print("Experience years: ");
            int experience = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            employees[i] = new Employee(name, age, salary, experience);
        }

        int totalEmployees = employees.length;
        double totalBonus = 0;
        double totalEarnings = 0;

        System.out.println("\nEmployee Details:");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.name);
            System.out.println("Age: " + employee.age);
            System.out.println("Salary: $" + employee.salary);
            System.out.println("Experience: " + employee.experience + " years");

            System.out.println("Bonus: $" + employee.calculateBonus());
            System.out.println("Total Earnings: $" + employee.calculateTotalEarnings());

            totalBonus += employee.calculateBonus();
            totalEarnings += employee.calculateTotalEarnings();
        }

        System.out.println("\nSummary:");
        System.out.println("Total employees: " + totalEmployees);
        System.out.println("Total bonus: $" + totalBonus);
        System.out.println("Total earnings: $" + totalEarnings);
        System.out.println("Average bonus: $" + (totalBonus / totalEmployees));
        System.out.println("Average total earnings: $" + (totalEarnings / totalEmployees));
    }
}