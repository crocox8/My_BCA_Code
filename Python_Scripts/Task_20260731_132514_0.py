# Assignment Question:
# Write a program to catch vehicle speed and tell how much petrol it needs to reach its 86 km destination if vehicles avg distance covered in 1 liter is 18 .
# Author: Ansh Pandey

def calculate_petrol(current_speed, destination_distance):
    avg_distance_per_litre = 18  # km per litre
    time_to_destination = destination_distance / current_speed  # hours
    total_distance_to_destination = avg_distance_per_litre * time_to_destination  # litres
    petrol_needed = total_distance_to_destination
    return petrol_needed

def main():
    destination_distance = float(input("Enter the destination distance in km: "))
    current_speed = float(input("Enter your vehicle's current speed in km/h: "))
    petrol_needed = calculate_petrol(current_speed, destination_distance)
    print("To reach your destination of {} km at a speed of {} km/h, you will need {:.2f} litres of petrol.".format(destination_distance, current_speed, petrol_needed))

if __name__ == "__main__":
    main()