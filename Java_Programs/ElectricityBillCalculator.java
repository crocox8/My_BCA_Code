// Assignment Question:
// Write a Java program to calculate the electricity bill based on the following conditions:
// Author: Ansh Pandey

import java.util.Scanner;

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total units consumed (in kWh): ");
        double unitsConsumed = scanner.nextDouble();

        System.out.print("Enter the cost per unit (in $): ");
        double costPerUnit = scanner.nextDouble();

        if (unitsConsumed <= 50) {
            double totalAmount = unitsConsumed * costPerUnit;
            System.out.println(" Electricity bill is $" + totalAmount);
        } else if (unitsConsumed <= 100) {
            double totalAmount = 250 + ((unitsConsumed - 50) * costPerUnit);
            System.out.println(" Electricity bill is $" + totalAmount);
        } else if (unitsConsumed <= 200) {
            double totalAmount = 370 + (((unitsConsumed - 100) * 0.5));
            System.out.println(" Electricity bill is $" + totalAmount);
        } else {
            double totalAmount = 370 + 100 + (((unitsConsumed - 200) * 0.75) * ((unitsConsumed - 200) / 100));
            System.out.println(" Electricity bill is $" + totalAmount);
        }

        scanner.close();
    }
}