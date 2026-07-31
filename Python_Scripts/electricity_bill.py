# Assignment Question:
# 7. Calculate Electricity Bill
# Author: Ansh Pandey

# Define a function to calculate electricity bill
def calculate_electricity_bill():
    # Get the usage from the user
    usage = float(input("Enter the electricity usage in kilowatt-hours (kWh): "))

    # Get the tariff per unit from the user
    tariff_per_unit = float(input("Enter the tariff per unit in dollars ($): "))

    # Calculate the total amount
    total_amount = usage * tariff_per_unit

    # Apply GST of 5%
    gst = total_amount * 0.05
    gst_amount = gst / 100

    # Calculate the total amount including GST
    total_amount_with_gst = total_amount + gst_amount

    # Print the result
    print("Bill Details:")
    print(f"Usage (kWh): {usage}")
    print(f"Tariff per unit ($): {tariff_per_unit}")
    print(f"Total amount ($): {total_amount}")
    print(f"GST (%): 5%")
    print(f"GST amount ($): {gst_amount}")
    print(f"Total amount + GST ($): {total_amount_with_gst}")

# Call the function
calculate_electricity_bill()