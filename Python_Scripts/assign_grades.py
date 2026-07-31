# Assignment Question:
# 6. Assign Grades Based on Marks
# Author: Ansh Pandey

def assign_grades(marks):
    grades = [
        (90, 100, 'A'),
        (80, 89, 'B'),
        (70, 79, 'C'),
        (60, 69, 'D'),
        (0, 59, 'F')
    ]
    result = []
    for mark in marks:
        for grade in grades:
            if mark >= grade[0]:
                result.append((mark, grade[1]))
                break
    return sorted(result, key=lambda x: x[0], reverse=True)

print(assign_grades([95, 75, 85, 65, 55]))
print(assign_grades([80, 90, 85, 75, 70]))
print(assign_grades([50, 45, 42, 39, 36]))