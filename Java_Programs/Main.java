// Assignment Question:
// **Assignment Question:**

Design and implement a Java application to manage the attendance of a University's Computer Science Department. Create a class named "StudentAttendance" that uses if-else statements and switch statements to determine the attendance status of a student based on the number of classes they have attended out of the total number of classes in a semester. The application should prompt the user to input the student's name, total number of classes in the semester, and the number of classes attended. Then, it should display the attendance status of the student, which should be one of the following: "Good", "Fair", or "Poor".
// Author: Ansh Pandey

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String studentName = scanner.next();

        System.out.print("Enter total number of classes in the semester: ");
        int totalClasses = scanner.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attendedClasses = scanner.nextInt();

        scanner.close();

        StudentAttendance attendance = new StudentAttendance(studentName, totalClasses, attendedClasses);

        attendance.displayAttendanceStatus();
    }
}

class StudentAttendance {
    private String studentName;
    private int totalClasses;
    private int attendedClasses;

    public StudentAttendance(String studentName, int totalClasses, int attendedClasses) {
        this.studentName = studentName;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public void displayAttendanceStatus() {
        double attendancePercentage = ((double) attendedClasses / totalClasses) * 100;

        if (attendancePercentage >= 90) {
            System.out.println(studentName + "'s attendance is: Good");
        } else if (attendancePercentage >= 60) {
            System.out.println(studentName + "'s attendance is: Fair");
        } else {
            System.out.println(studentName + "'s attendance is: Poor");
        }
    }
}