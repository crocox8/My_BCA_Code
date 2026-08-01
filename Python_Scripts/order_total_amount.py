# Assignment Question:
# ₹10,000 or more → 30% discount
# Author: Ansh Pandey

# Function to calculate the discounted price
def calculate_discounted_price(price):
    if price >= 10000:
        # Applying 30% discount
        discount = (price * 30) / 100
        discounted_price = price - discount
        return round(discounted_price, 2)
    else:
        # No discount
        return round(price, 2)

# Function to get user input
def get_user_input():
    while True:
        try:
            price = float(input("Enter the price: ₹"))
            if price < 0:
                print("Price cannot be negative.")
            else:
                break
        except ValueError:
            print("Invalid input. Please enter a number.")

    # Calculate and display the discounted price
    return price

# Main function
def main():
    user_price = get_user_input()
    discounted_price = calculate_discounted_price(user_price)

    # Displaying output
    print(f"Discounted Price: ₹{discounted_price}")

# Run the main function
if __name__ == "__main__":
    main()