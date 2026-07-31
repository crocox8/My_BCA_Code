# Assignment Question:
# Up to 100 units → ₹5 per unit
# Author: Ansh Pandey

class PricingCalculator:
    def __init__(self):
        self.cost_per_unit = 5

    def calculate_price(self, units):
        if 0 <= units <= 100:
            return units * self.cost_per_unit


class InvoiceGenerator:
    def __init__(self, calculator):
        self.calculator = calculator

    def generate_invoice(self, customer_name, units):
        price = self.calculator.calculate_price(units)
        return f"Invoice for: {customer_name}\nPrice: ₹{price}"


def main():
    calculator = PricingCalculator()
    generator = InvoiceGenerator(calculator)
    
    customer_name = "John Doe"
    units = 50
    
    invoice = generator.generate_invoice(customer_name, units)
    print(invoice)


if __name__ == "__main__":
    main()