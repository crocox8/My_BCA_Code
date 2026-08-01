# Assignment Question:
# Original Amount
# Author: Ansh Pandey

def original_amount():
    amount = float(input("Enter the current amount: "))
    rate = float(input("Enter the interest rate percent: "))

    amount_in_years = 0

    while True:
        print(f"Year {amount_in_years + 1}, Amount: ${amount:.2f}")
        amount = (1 + (rate / 100)) * amount
        amount_in_years += 1

        choice = input("Do you want to continue to see the future amounts? (yes/no): ")
        if choice.lower() != "yes":
            break

def main():
    original_amount()

if __name__ == "__main__":
    main()