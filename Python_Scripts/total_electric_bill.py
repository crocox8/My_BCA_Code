# Assignment Question:
# Display the total electricity bill.
# Author: Ansh Pandey

bill = 1000  # Base bill
electricity_charge = 0.15  # Electricity charge per unit
unit_consumed = 600  # Number of units consumed

# Calculate total bill
total_bill = bill + (unit_consumed * electricity_charge)

# Print total bill
print("Your total electricity bill is: ₹", round(total_bill, 2))

def main():
    print("Electricity Bill Calculator")

    while True:
        print("\nOptions:")
        print("1. Calculate Bill")
        print("2. Exit")
        
        choice = input("Enter your choice: ")

        if choice == "1":
            bill = 1000  # Base bill
            electricity_charge = 0.15  # Electricity charge per unit
            unit_consumed = float(input("Enter number of units consumed: "))

            # Calculate total bill
            total_bill = bill + (unit_consumed * electricity_charge)

            # Print total bill
            print("Your total electricity bill is: ₹", round(total_bill, 2))
            
        elif choice == "2":
            print("Exiting...");
            break
        else:
            print("Invalid option. Please choose a valid option.")

if __name__ == "__main__":
    main()