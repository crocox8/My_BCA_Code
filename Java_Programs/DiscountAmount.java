// Assignment Question:
// Discount Amount
// Author: Ansh Pandey

import java.util.Scanner;

public class DiscountAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter original price:");
        float originalPrice = sc.nextFloat();

        System.out.println("Enter discount percentage:");
        float discountPercentage = sc.nextFloat();

        float discountAmount = (originalPrice * discountPercentage) / 100;

        System.out.println("Discount Amount: " + discountAmount);

        float finalAmount = originalPrice - discountAmount;

        System.out.println("Final Amount after discount: " + finalAmount);

        // yeh discountAmount ka calculation tha

        // check karo yeh finalAmount kya hai
        if (finalAmount <= 0) {
            System.out.println("Final amount cannot be negative");
            System.exit(0);
        }

        // ab yeh code finally finish ho gaya hai
        System.out.println("Code Successfully executed!");
    }
}