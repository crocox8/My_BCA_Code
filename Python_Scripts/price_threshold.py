# Assignment Question:
# Above 200 units → ₹10 per unit
# Author: Ansh Pandey

class Product:
    def __init__(self):
        pass

    def calculate_price(self, units):
        if units < 0:
            raise ValueError("Units cannot be negative")
        if units <= 200:
            return units * 5
        else:
            return units * 10


# Test the Product class
product = Product()
tests = [199, 200, 201, 500]
for unit_count in tests:
    try:
        price = product.calculate_price(unit_count)
        print(f"{unit_count} units: ₹{price}")
    except ValueError as e:
        print(f"Error: {e}")