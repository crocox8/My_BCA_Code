// Assignment Question:
// ₹5,000–₹9,999 → 15% discount
// Author: Ansh Pandey

// Java programming language se code likh hain

import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        scanner.close();

        // Discount ki sharton ki check karo
        if (price >= 5000 && price <= 9999) {
            double discount = price * 0.15;
            double finalPrice = price - (int) discount;
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final price: ₹" + finalPrice);
        } else {
            System.out.println("Discount nhi milta hai, aapke price mein.");
        }
    }
}