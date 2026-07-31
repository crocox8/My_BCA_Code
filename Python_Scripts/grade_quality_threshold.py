# Assignment Question:
# Marks ≥ 90 → Grade A
# Author: Ansh Pandey

def calculate_grade(marks):
    if marks >= 90:
        return "Grade A"

def main():
    marks = float(input("Enter your marks: "))
    grade = calculate_grade(marks)
    print(f"Your grade is: {grade}")

if __name__ == "__main__":
    main()