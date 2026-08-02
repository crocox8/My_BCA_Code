# Assignment Question:
# During a festival sale, a store offers discounts based on the purchase amount:
# Author: Ansh Pandey

# Lab Assignment 6: Festival Discount Calculator
# By: XYZ (BCA IIIrd Semester)
# Date: 03-Aug-2026

amount = float(input("Enter purchase amount in Rs.: "))

# Loop chalate hain, sabhi shreemat ke liye
if amount <= 500:
    discount = 0
elif 500 < amount <= 2000:
    discount = (amount - 500) * 0.05
elif 2000 < amount <= 5000:
    discount = (1000) * 0.05 + ((amount - 2000) * 0.10)
else:
    discount = (1000) * 0.05 + (2000 * 0.10) + ((amount - 5000) * 0.15)

# Condition check karo
final_amount = amount - discount

# Final output
print("Discount:", round(discount,2))
print("Final Purchase Amount after discount: ", round(final_amount,2))