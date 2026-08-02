# Assignment Question:
# Below ₹1,000 → 5% discount
# Author: Ansh Pandey

class Bill:
    def __init__(self, bill_amount):
        self.bill_amount = bill_amount

    def calculate_discount(self):
        if self.bill_amount <= 1000:
            discount = self.bill_amount * 0.05
            self.final_amount = self.bill_amount - discount
            print(f"The Bill amount is ₹{self.bill_amount}. Discount of ₹{discount:.2f} applied. Final bill: ₹{self.final_amount:.2f}")

amount = float(input("Enter the bill amount: "))
bill = Bill(amount)
bill.calculate_discount()