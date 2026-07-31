# Assignment Question:
# Implement a Java program to create a simple banking system with the following features:

- Create a class 'Account' with attributes : account number, account holder's name, balance.
- Include methods to deposit, withdraw, check balance and display account details.
- Implement a method to compare and display the largest balance between two accounts.
- Create two objects of the 'Account' class with different account details.
- Write a method to find and display the details of the account with the balance closest to the mean balance of all accounts.
- Use multi-level inheritance for the classes: 'Account' class should inherit from a 'BankingSystem' class, and the 'BankingSystem' class should inherit from a 'System' class. The 'System' class should be an abstract class.

import java.util.*;

interface System {
    void printMessage();
}

abstract class BankingSystem implements System {
    public abstract void printAccountDetails(Account account);
}

class SystemImpl extends BankingSystem {
    @Override
    public void printMessage() {
        System.out.println("Banking System");
    }

    @Override
    public void printAccountDetails(Account account) {
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Name: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());
    }
}

class Account extends BankingSystem {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". Current balance: " + balance);
        printMessage();
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Current balance: " + balance);
            printMessage();
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
        printMessage();
    }

    public void displayAccountDetails() {
        printAccountDetails(this);
    }

    public void compareBalance(Account otherAccount) {
        if (balance > otherAccount.getBalance()) {
            System.out.println("Account " + this.getAccountNumber() + " has the largest balance.");
        } else {
            System.out.println("Account " + otherAccount.getAccountNumber() + " has the largest balance.");
        }
    }

    public static double findClosestAccountBalance(List<Account> accounts, double meanBalance) {
        double minDifference = Math.abs(accounts.get(0).getBalance() - meanBalance);
        Account closestAccount = accounts.get(0);
        for (Account account : accounts) {
            double difference = Math.abs(account.getBalance() - meanBalance);
            if (difference < minDifference) {
                minDifference = difference;
                closestAccount = account;
            }
        }
        return closestAccount.getBalance();
    }
}

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("67890", "Jane Doe", 500.0);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        double meanBalance = 0;
        for (Account account : accounts) {
            meanBalance += account.getBalance();
        }
        meanBalance /= accounts.size();

        System.out.println("Account details:");
        account1.displayAccountDetails();
        account2.displayAccountDetails();

        System.out.println("\nAccount balance comparison:");
        account1.compareBalance(account2);

        System.out.println("\nWithdrawal:");
        account1.withdraw(200);

        System.out.println("\nDeposits:");
        account1deposit(100);
        account2.deposit(50);

        System.out.println("\nChecking balance:");
        account1.checkBalance();
        account2.checkBalance();

        System.out.println("\nAccount with balance closest to the mean balance:");
        double closestBalance = Account.findClosestAccountBalance(accounts, meanBalance);
        System.out.println("Account with balance closest to the mean balance: " + closestBalance);
    }

    public static void account1deposit(double amount) {
        Account account1 = new Account("12345", "John Doe", 1000.0);
        account1.deposit(amount);
    }
}