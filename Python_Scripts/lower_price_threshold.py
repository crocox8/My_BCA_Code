# Assignment Question:
# ₹2,000 to ₹4,999 → 10% discount
# Author: Ansh Pandey

def calculate_discount(price):
    if 2000 <= price <= 4999:
        discount_amount = price * 0.10
        discount_price = price - discount_amount
    else:
        discount_price = price
    return discount_price

price = float(input("Enter the purchase price: "))
discounted_price = calculate_discount(price)
print("Discounted price: ₹", round(discounted_price, 2))