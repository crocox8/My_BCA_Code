# Assignment Question:
# 😘
# Author: Ansh Pandey

def calculate_expression(exp):
    try:
        result = eval(exp)
        return result
    except Exception as e:
        return f"Invalid expression: {str(e)}"

def validate_input(prompt):
    while True:
        user_input = input(prompt)
        if user_input.replace('.', '', 1).replace('-', '', 1).isdigit() or user_input.replace('.', '', 1).replace('-', '', 1).isalpha():
            if user_input.replace('.', '', 1).replace('-', '', 1).isdigit():
                return float(user_input)
            elif user_input.replace(' ', '', 1).replace('.', '', 1).replace('-', '', 1).isalpha():
                return user_input
        else:
            print("Invalid input. Please try again.")

def calculate_sum(numbers):
    return sum(numbers)

def subtract(x, y):
    return x - y

def multiply(x, y):
    return x * y

def divide(x, y):
    if y != 0:
        return x / y
    else:
        return "Error: Division by zero"

def calculator():
    while True:
        print("\nCalculator Menu")
        print("1. Expression")
        print("2. Arithmetic Operations")
        print("3. Quit")
        choice = validate_input("Enter choice: ")

        if choice == '1':
            expression = input("Enter expression: ")
            print(calculate_expression(expression))
        elif choice == '2':
            while True:
                num1 = validate_input("Enter first number: ")
                num2 = validate_input("Enter second number: ")

                print("\nArithmetic Operations Menu")
                print("1. Sum")
                print("2. Subtract")
                print("3. Multiply")
                print("4. Divide")
                print("5. Back")

                choice = validate_input("Enter choice: ")
                if choice == '1':
                    result = calculate_sum([num1, num2])
                    print(f"Result: {result}")
                elif choice == '2':
                    result = subtract(num1, num2)
                    print(f"Result: {result}")
                elif choice == '3':
                    result = multiply(num1, num2)
                    print(f"Result: {result}")
                elif choice == '4':
                    result = divide(num1, num2)
                    print(f"Result: {result}")
                elif choice == '5':
                    break
                else:
                    print("Invalid choice. Please try again.")
        elif choice == '3':
            print("Exiting calculator. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")

calculator()