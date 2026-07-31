# Assignment Question:
# Marks ≥ 40 → Grade D
# Author: Ansh Pandey

def calculate_grade(marks):
    if marks >= 40:
        print('Grade D')

marks = float(input("Please enter your marks: "))
calculate_grade(marks)