# Assignment Question:
# 4. Find the Largest of Three Numbers
# Author: Ansh Pandey

def find_largest_number(a, b, c):
    largest = a
    if b > largest:
        largest = b
    if c > largest:
        largest = c
    return largest

num1 = int(input("Enter the first number: "))
num2 = int(input("Enter the second number: "))
num3 = int(input("Enter the third number: "))

print("The largest number among", num1, num2, "and", num3, "is", find_largest_number(num1, num2, num3))