// Assignment Question:
// Write a Java program to input marks (0–100) and display the grade according to the following criteria:
// Author: Ansh Pandey

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks (0-100): ");
        int marks = scanner.nextInt();

        scanner.close();

        while (marks < 0 || marks > 100) {
            System.out.print("Invalid input. Enter marks between 0 and 100: ");
            marks = scanner.nextInt();
        }

        displayGrade(marks);
    }

    public static void displayGrade(int marks) {
        if (marks >= 80) {
            System.out.println("Grade: A");
        } else if (marks >= 70) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else if (marks >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}