# Assignment Question:
# Write a program to catch vehicle speed and tell how much petrol it needs to reach its 885 km destination if vehicles avg distance covered in 1 liter is 18 .
# Author: Ansh Pandey

# Define a class to calculate vehicle petrol
class VehiclePetrolCalculator:
    def __init__(self):
        self.average_distance_per_liter = 18  # km/liter
        self.destination_distance = 885  # km

    def calculate_petrol_needed(self):
        petrol_needed = self.destination_distance / self.average_distance_per_liter
        return petrol_needed

def main():
    calculator = VehiclePetrolCalculator()
    petrol_needed = calculator.calculate_petrol_needed()
    print("Petrol needed to reach a distance of {:.2f} km: {:.2f} litres".format(calculator.destination_distance, petrol_needed))

if __name__ == "__main__":
    main()