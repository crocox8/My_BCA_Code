// Assignment Question:
// Write a java program to calculate speed and time .
// Author: Ansh Pandey

import java.util.Scanner;

public class SpeedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter distance (in miles or kilometers): ");
        String dist = scanner.nextLine();
        System.out.print("Enter unit of distance (miles/km): ");
        String distUnit = scanner.nextLine();

        System.out.print("Enter time (in hours or minutes): ");
        String time = scanner.nextLine();
        System.out.print("Enter unit of time (hours/minutes): ");
        String timeUnit = scanner.nextLine();

        double distance;
        double timeInSeconds;
        double speed;

        if (distUnit.equalsIgnoreCase("miles")) {
            distance = Double.parseDouble(dist);
        } else if (distUnit.equalsIgnoreCase("km")) {
            distance = Double.parseDouble(dist) * 0.621371;
        } else {
            System.out.println("Invalid unit of distance");
            System.exit(0);
        }

        if (timeUnit.equalsIgnoreCase("hours")) {
            timeInSeconds = Double.parseDouble(time) * 3600;
        } else if (timeUnit.equalsIgnoreCase("minutes")) {
            timeInSeconds = Double.parseDouble(time) * 60;
        } else {
            System.out.println("Invalid unit of time");
            System.exit(0);
        }

        speed = (distance / timeInSeconds) * 3600;

        System.out.println("Speed in miles/hour: " + speed / 3600);
        System.out.println("Speed in kilometers/hour: " + speed / 1000);
    }
}