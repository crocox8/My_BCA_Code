# Assignment Question:
# 1. Check Whether a Number is Positive, Negative, or Zero
# Author: Ansh Pandey

def check_number(n):
    if n > 0:
        return "positive"
    elif n < 0:
        return "negative"
    else:
        return "zero"

num = float(input("Enter a number: "))
print(f"The number {num} is {check_number(num)}")

def check_number(n):
    return "positive" if n > 0 else "negative" if n < 0 else "zero"

num = float(input("Enter a number: "))
print(f"The number {num} is {check_number(num)}")