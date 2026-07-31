# Assignment Question:
# Write a program in python to check is the number is divisible by 53 or not
# Author: Ansh Pandey

def is_divisible(num):
    if num % 53 == 0:
        return "The number is divisible by 53"
    else:
        return "The number is not divisible by 53"

num = int(input("Enter a number: "))
print(is_divisible(num))