# Assignment Question:
# Marks ≥ 60 → Grade C
# Author: Ansh Pandey

def calculate_grade(marks):
    if marks >= 60:
        return "Grade C"
    else:
        return "Failed"

marks = int(input("Enter Marks: "))
print("Grade: ", calculate_grade(marks))