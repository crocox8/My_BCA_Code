// Assignment Question:
// Assignment 3: Bank Account Inheritance

Create a Java program that simulates a bank account system using inheritance. You have three types of bank accounts: Basic, Premium, and Gold. 

Basic accounts have a minimum balance of ₹100 and charge a monthly fee of ₹10. Premium accounts have a 50% reduction in monthly fee, but are restricted to withdrawals of ₹1000 per day. Gold accounts have all the features of premium accounts plus an additional interest rate of 2% and an overdraft facility of ₹5000. 

Design an abstract base class called BankAccount with properties for account number, balance, name, and date of creation. Override the deposit and withdraw methods in each child class to suit their respective requirements. Use method overriding and method overloading as required.
// Author: Ansh Pandey

import java.time.LocalDate;

abstract class BankAccount {
    protected int accountNumber;
    protected double balance;
    protected String name;
    protected LocalDate dateCreated;

    public BankAccount(int accountNumber, double balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.dateCreated = LocalDate.now();
    }

    public abstract boolean withdraw(double amount);

    public abstract void deposit(double amount);

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Name: " + name);
        System.out.println("Date of Creation: " + dateCreated);
    }
}

class BasicAccount extends BankAccount {
    private static final double MONTHLY_FEE = 10;
    private static final double MIN_BALANCE = 100;

    public BasicAccount(int accountNumber, double balance, String name) {
        super(accountNumber, balance, name);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Basic Account Info:");
        super.displayInfo();
        System.out.println("Monthly Fee: ₹" + MONTHLY_FEE);
    }
}

class PremiumAccount extends BankAccount {
    private static final double MONTHLY_FEE = 5;
    private static final double MAX_WITHDRAWAL = 1000;

    public PremiumAccount(int accountNumber, double balance, String name) {
        super(accountNumber, balance, name);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= MAX_WITHDRAWAL) {
            if (balance - amount >= 0) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Account Info:");
        super.displayInfo();
        System.out.println("Monthly Fee: ₹" + MONTHLY_FEE);
        System.out.println("Max Daily Withdrawal: ₹" + MAX_WITHDRAWAL);
    }
}

class GoldAccount extends PremiumAccount {
    private static final double INTEREST_RATE = 0.02;
    private static final double OVERDRAFT_LIMIT = 5000;

    public GoldAccount(int accountNumber, double balance, String name) {
        super(accountNumber, balance, name);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount + OVERDRAFT_LIMIT >= 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Interest earned: ₹" + (balance - amount) * INTEREST_RATE);
        balance += (balance - amount) * INTEREST_RATE;
    }

    @Override
    public void displayInfo() {
        System.out.println("Gold Account Info:");
        super.displayInfo();
        System.out.println("Overdraft Limit: ₹" + OVERDRAFT_LIMIT);
        System.out.println("Interest Rate: " + INTEREST_RATE * 100 + "%");
    }
}

class Main {
    public static void main(String[] args) {
        BasicAccount basic = new BasicAccount(1, 200, "John Doe");
        basic.displayInfo();
        System.out.println();
        basic.deposit(500);
        System.out.println();
        basic.withdraw(100);
        basic.withdraw(200);
        basic.displayInfo();

        System.out.println();

        PremiumAccount premium = new PremiumAccount(2, 200, "Jane Doe");
        premium.displayInfo();
        System.out.println();
        premium.deposit(500);
        System.out.println();
        premium.withdraw(100);
        premium.withdraw(500);
        premium.withdraw(500);
        premium.displayInfo();
        System.out.println();

        GoldAccount gold = new GoldAccount(3, 200, "Bob Smith");
        gold.displayInfo();
        System.out.println();
        gold.deposit(500);
        System.out.println();
        gold.withdraw(100);
        gold.withdraw(5000);
        gold.withdraw(-5000);
        gold.displayInfo();
    }
}