// Assignment Question:
// Write a Java program to input the total shopping amount and calculate the final payable amount using the following discount policy:
// Author: Ansh Pandey

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total shopping amount: ");
        double totalAmount = scanner.nextDouble();

        System.out.println("Select discount type:");
        System.out.println("1. Flat discount of Rs. 200");
        System.out.println("2. Percentage discount of 10%");
        System.out.println("3. No discount");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double discount;
        switch (choice) {
            case 1:
                discount = 200;
                break;
            case 2:
                discount = totalAmount * 0.1;
                break;
            default:
                discount = 0;
                break;
        }

        double payableAmount = totalAmount - discount;

        System.out.println("Total shopping amount: " + totalAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Final payable amount: " + payableAmount);
    }
}