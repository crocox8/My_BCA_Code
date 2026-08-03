// Assignment Question:
// ₹10,000 and above → 25% discount
// Author: Ansh Pandey

public class DiscountCalculator {
    public static void main(String[] args) {
        // Input amount
        int amount = 10000;
        
        // Discount percentage
        int discountPercentage = 25;
        
        // Convert discount percentage to decimal
        double discountDecimal = (double) discountPercentage / 100;
        
        // Calculate the discount
        double discount = amount * discountDecimal;
        
        // Discount after rounding off
        double discountAfterRoundingOff = Math.round(discount * 100) / 100;
        
        // Total amount after discount
        double totalAmountAfterDiscount = amount - discountAfterRoundingOff;
        
        // loop chalate hain to check for different amounts and calculate accordingly
        for (int i = 10000; i <= 50000; i += 1000) {
            amount = i;
            // Condition check karo if amount is 10000 or more
            if (amount >= 10000) {
                // Calculate the discount
                discount = amount * discountDecimal;
                // Discount after rounding off
                discountAfterRoundingOff = Math.round(discount * 100) / 100;
                // Total amount after discount
                totalAmountAfterDiscount = amount - discountAfterRoundingOff;
                // System.out.println will be replaced with console.println for simplicity
                System.out.println("For amount Rs. " + i + ", your total amount after discount of " + discountAfterRoundingOff + " is Rs. " + totalAmountAfterDiscount);
            }
        }
        
        // final output
        System.out.println("Thanks for using our Discount Calculator!");
    }
}