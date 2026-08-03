# Assignment Question:
# ₹1,000–₹4,999 → 10% discount
# Author: Ansh Pandey

# Discount Calculator in Python

# Sabse pehle discount range ka scope define karte hain
def calculate_discount(price):
    # Loop chalaate hain jisme discount kya hai?
    for i in range(1000, 5000):
        if i >= 1000 and i <= 4999:
            # 10% discount se calculate karte hain
            discount = (i * 10) / 100
            # Final amount ko print karte hain
            print(f"Discount on ₹{i}: ₹{discount}, Final amount: ₹{(i - discount)}")
            return

# Sabse aakhir mein function ko call karte hain
calculate_discount(0)