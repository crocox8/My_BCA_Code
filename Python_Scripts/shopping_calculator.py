# Assignment Question:
# 8. Shopping Discount Calculator
# Author: Ansh Pandey

def calculate_discount(price, discount_percentage):
    return price * (1 - discount_percentage / 100)

def apply_discount(original_price, discount_percentage):
    return original_price - calculate_discount(original_price, discount_percentage)

def shopping_discount_calculator():
    try:
        while True:
            print("\nShopping Discount Calculator Menu:")
            print("1. Calculate discount")
            print("2. Apply discount")
            print("3. Exit")
            choice = int(input("Enter your choice: "))
            if choice == 1:
                price = float(input("Enter the original price: "))
                discount_percentage = float(input("Enter the discount percentage: "))
                print(f"Discount: {calculate_discount(price, discount_percentage):.2f}")
            elif choice == 2:
                original_price = float(input("Enter the original price: "))
                discount_percentage = float(input("Enter the discount percentage: "))
                print(f"Final price after discount: {apply_discount(original_price, discount_percentage):.2f}")
            elif choice == 3:
                print("Exiting the application.")
                break
            else:
                print("Invalid choice. Please choose a valid option.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")

shopping_discount_calculator()