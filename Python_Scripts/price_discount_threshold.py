# Assignment Question:
# ₹5,000 to ₹9,999 → 20% discount
# Author: Ansh Pandey

def calculate_discount():
    total_amount = float(input("Enter total amount between ₹5,000 to ₹9,999: "))
    
    if 5000 <= total_amount <= 9999:
        discount_percentage = 20
        discount_amount = (total_amount / 100) * discount_percentage
        final_amount = total_amount - discount_amount
    else:
        print("Invalid amount. Please enter an amount between ₹5,000 and ₹9,999.")
        return
    
    print(f"Discount Amount: ₹{discount_amount:.2f}")
    print(f"Final Amount after Discount: ₹{final_amount:.2f}")

calculate_discount()