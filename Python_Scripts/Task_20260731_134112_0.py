# Assignment Question:
# Write a python program to catch vehicle speed and tell how much petrol it needs to reach its 86 km destination if vehicles avg distance covered in 1 liter is 12 .
# Author: Ansh Pandey

def calculate_petrol_needed():
    average_distance_per_liter = 12  # km per liter
    destination_distance = 86  # km
    speed = float(input("Enter the vehicle's average speed in km per hour: "))
    time_to_reach_destination = destination_distance / speed
    litres_needed = time_to_reach_destination / (average_distance_per_liter / speed)
    
    print(f"The vehicle needs {litres_needed:.2f} liters of petrol to reach its destination.")

calculate_petrol_needed()