# Assignment Question:
# Write a python script to add 5 numbers

# Define a list with 5 numbers to be added
numbers = [15.5, 25, 3, 8.5, 10]

try:
    # Calculate the sum of the numbers using the built-in sum function
    result = sum(numbers)

    # Print the sum as an integer with two decimal places
    print("Sum: {:.2f}".format(result))

except TypeError:
    print("All elements in the list must be numbers.")