# Assignment Question:
# Final Amount to Pay
# Author: Ansh Pandey

import math

def final_amount_to_pay():
    print("Marksheet ke aadhar par Final Amount to Pay Calculator")
    amount1 = int(input("Aadhar shulk ka amount dahaye: "))
    amount2 = int(input("Tuition fees ka amount dahaye: "))
    discount = int(input("Discount ka percentage dahaye: "))

    total_amount = (amount1 + amount2) # total_amount = aadhar shulk + tuition fees
    print("Total amount = ", total_amount)

    final_discount = (total_amount * discount) / 100 # discount amount
    print("Discount amount = ", final_discount)

    final_amount = total_amount - final_discount # final_amount = total_amount - discount
    print("Baki rakhne ke liye final amount dahaye: ", final_amount)

    if final_amount > 0:
        print("Aapko kuch bhi chahiye nahin.")
    else:
        print("Aapko kamshulak karo jee.")

final_amount_to_pay()