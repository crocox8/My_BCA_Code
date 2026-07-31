// Assignment Question:
// Write a Java program to implement Exception Handling by creating a custom 'BankAccountException' that extends the standard 'Exception' class. Within your BankAccount class, include methods to deposit, withdraw, and check balance. Handle the potential exceptions that may occur during these operations using your custom 'BankAccountException'.
// Author: Ansh Pandey

// Custom Exception Class
class BankAccountException extends Exception {
    public BankAccountException(String message) {
        super(message);
    }
}

// BankAccount Class
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws BankAccountException {
        if (amount <= 0) {
            throw new BankAccountException("Deposit amount should be greater than zero");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws BankAccountException {
        if (amount <= 0) {
            throw new BankAccountException("Withdrawal amount should be greater than zero");
        }
        if (amount > balance) {
            throw new BankAccountException("Insufficient balance");
        }
        balance -= amount;
    }

    public void checkBalance() {
        System.out.println("Your current balance is $" + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.deposit(500);
            account.withdraw(700);
            account.checkBalance();
        } catch (BankAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.withdraw(1500);
        } catch (BankAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.deposit(-200);
        } catch (BankAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

This code will handle potential exceptions that may occur during deposit, withdrawal, and checking of balance operations in a BankAccount class, utilizing a custom BankAccountException.