// Assignment Question:
// 9. Festival Discount Calculator
// Author: Ansh Pandey

public class FestivalDiscountCalculator {
    public static void main(String[] args) {
        int costOfTickets = 10000;
        int festivalDiscountPercentage = 20;
        int transportDiscountPercentage = 5;
        int festivalDiscountAmount;
        int transportDiscountAmount;
        int totalDiscountAmount = 0;
        int totalCostAfterDiscount = 0;

        // loop chalate hain
        for (int i = 0; i < 100; i++) {
            festivalDiscountAmount = costOfTickets * festivalDiscountPercentage / 100;
            transportDiscountAmount = costOfTickets * transportDiscountPercentage / 100;

            totalDiscountAmount = festivalDiscountAmount + transportDiscountAmount;

            totalCostAfterDiscount = (costOfTickets - totalDiscountAmount);

            System.out.println("Festival Discount: " + festivalDiscountAmount + " Transport Discount: " + transportDiscountAmount +
                    " Total Discount: " + totalDiscountAmount + " Total Cost After Discount: " + totalCostAfterDiscount);
        }

        // condition check karo
        if (totalCostAfterDiscount < 0) {
            System.out.println("Invalid discount amount, please adjust festival and transport discount percentage");
        } else {
            System.out.println("Yay! Total cost after discount is within limits");
        }

        // final output
        System.out.println("Festival Discount Calculator");
        System.out.println("Program by: [Your Name]");
    }
}