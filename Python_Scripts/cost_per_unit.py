# Assignment Question:
# 101–200 units → ₹7 per unit
# Author: Ansh Pandey

def calculate_bill(units):
    if 101 <= units <= 200:
        return units * 7
    else:
        print("Invalid unit range. Please enter units between 101 and 200.")

# Testing the function
units = int(input("Enter units: "))
bill = calculate_bill(units)
if bill is not None:
    print("Bill amount: ₹", bill)