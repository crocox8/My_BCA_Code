// Assignment Question:
// Assignment:

**Problem 5: Restaurant Billing System**

Create a Java program that simulates a simple restaurant billing system. The system should have the following features:

- A `FoodItem` class with attributes for item name, price, and quantity.
- A `Bill` class with attributes for customer name, bill total, and items (using the `FoodItem` class).
- A `constructor` in the `Bill` class that takes customer name as an argument and initializes the bill total to zero.
- A `method` in the `Bill` class called `addItem` that allows adding a `FoodItem` to the bill, and updates the bill total accordingly.
- A `method` in the `Bill` class called `displayBill` that prints out the customer name, bill total, and a list of all items in the bill.
// Author: Ansh Pandey

public class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

public class Bill {
    private String customerName;
    private double billTotal;
    private FoodItem[] items;
    private int itemIndex;

    public Bill(String customerName) {
        this.customerName = customerName;
        this.billTotal = 0;
        this.items = new FoodItem[10];
        this.itemIndex = 0;
    }

    public void addItem(FoodItem item) {
        if (itemIndex < items.length) {
            items[itemIndex] = item;
            item.setQuantity(item.getQuantity() * (itemIndex + 1));
            billTotal += (item.getPrice() * item.getQuantity());
            itemIndex++;
        } else {
            System.out.println("Maximum number of items reached.");
        }
    }

    public void displayBill() {
        System.out.println("Bill for " + customerName);
        System.out.println("Total: $" + billTotal);
        for (int i = 0; i < itemIndex; i++) {
            System.out.println(items[i].toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Bill bill = new Bill("John Doe");

        FoodItem pizza = new FoodItem("Pizza", 15.0, 1);
        bill.addItem(pizza);
        bill.addItem(pizza);
        bill.addItem(new FoodItem("Burger", 10.0, 2));

        bill.displayBill();
    }
}