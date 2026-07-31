# Assignment Question:
# Marks ≥ 75 → Grade B
# Author: Ansh Pandey

marks = float(input("Enter marks: "))

if marks >= 75:
    grade = 'B'
elif marks >= 60:
    grade = 'C'
elif marks >= 50:
    grade = 'D'
elif marks >= 40:
    grade = 'E'
else:
    grade = 'F'

print(f'Marks: {marks:.2f}, Grade: {grade}')