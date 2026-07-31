// Assignment Question:
// Develop a multi-threaded Java application that simulates a bank cashier system. The cashier system should have the following features: 

- It should have multiple customer-thread classes where each thread represents a customer.
- Each customer thread should create an account, display its account details, deposit money, withdraw money, and check balance for its account.
- The application should also have a single cashier-thread class that creates multiple customer-thread objects, starts each customer thread, and waits for them to finish.
- The cashier-thread should also display the final balance of each customer's account after all customer threads have finished.
// Author: Ansh Pandey

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int balance;
    private String accountNumber;
    private String accountHolder;

    public Account(String customerName) {
        this.balance = 0;
        this.accountNumber = "1234567890" + String.valueOf(Math.random() * 999999999);
        this.accountHolder = customerName;
    }

    public int getBalance() {
        return balance;
    }

    public void depositAmount(int amount) {
        balance += amount;
    }

    public void withdrawAmount(int amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds");
        }
        balance -= amount;
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: " + balance;
    }
}

class CustomerThread extends Thread {
    private Account account;
    private Lock lock = new ReentrantLock();

    public CustomerThread(Account account, String threadName) {
        this.account = account;
        this.setName(threadName);
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " has started");
        Thread.sleep(1000);

        System.out.println(threadName + " has logged in");
        lock.lock();
        try {
            System.out.println(account.getAccountDetails());
            System.out.println(threadName + " deposited $1000");
            account.depositAmount(1000);
            System.out.println(account.getAccountDetails());
            System.out.println(threadName + " withdrew $200");
            account.withdrawAmount(200);
            System.out.println(account.getAccountDetails());
        } catch (Exception e) {
            System.out.println(threadName + " " + e.getMessage());
        } finally {
            lock.unlock();
        }

        System.out.println(threadName + " has finished");
    }
}

class CashierThread extends Thread {
    private Account[] accounts;
    private String cashierName;

    public CashierThread(Account[] accounts, String cashierName) {
        this.accounts = accounts;
        this.cashierName = cashierName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " has started");
        Thread.sleep(1000);

        System.out.println(threadName + " is serving customers");
        for (Account account : accounts) {
            String customerName = Thread.currentThread().getName();
            CustomerThread customerThread = new CustomerThread(account, customerName);
            customerThread.start();
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + " has finished serving customers");
        System.out.println(threadName + " is displaying final balances");
        for (Account account : accounts) {
            System.out.println(account.getAccountDetails());
        }
    }
}

public class BankCashierSystem {
    public static void main(String[] args) {
        String[][] customers = {
            {"John", "Alice", "Eve"},
            {"Bob", "Mary", "Mike"},
        };

        Account[] accounts = new Account[3 * customers.length];
        for (int i = 0; i < accounts.length; ++i) {
            accounts[i] = new Account(customers[i % customers.length][0]);
        }

        CashierThread cashierThread = new CashierThread(accounts, "Bank Cashier");
        cashierThread.start();
        try {
            cashierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
This Java program simulates a multi-threaded bank cashier system. Multiple customer threads create accounts, display account details, deposit money, withdraw money, and check balances. The cashier thread starts each customer thread, waits for them to finish, and displays the final balance of each account. 

Here's a brief description of how the program works:

1. The program creates an array of account objects to simulate multiple customer accounts.

2. It creates a cashier thread that starts each customer thread and waits for them to finish.

3. Each customer thread represents a customer and logs in, displays its account details, deposits money, withdraws money, and checks the balance.

4. After all customer threads have finished, the cashier thread displays the final balance of each account.