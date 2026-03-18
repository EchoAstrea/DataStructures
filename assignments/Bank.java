/*
 * Tessa Dalbo
 * Program 2
 * due 9/11/2025
 * This program simulates a banking system
 * where the user can deposit, withdraw, and show the balance
 * of their account
 */

package programs;

import java.util.Scanner;

class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void showBalance() {
        System.out.println(name + ": Your balance = $" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": Your balance = $" + balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return name.equalsIgnoreCase(account.name);
    }
}

class BankProgram {
    private Account[] accounts;
    private int size;

    public BankProgram(int capacity) {
        accounts = new Account[capacity];
        size = 0;
    }
    public void addAccount(Account account) {
        if (size < accounts.length) {
            accounts[size] = account;
            size++;
        } else {
            System.out.println("Bank is at full capacity. Cannot add more accounts.");
        }
    }
    public Account find(String name) {
        for (int i = 0; i < size; i++) {
            if (accounts[i].getName().equalsIgnoreCase(name)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void printTotal() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            System.out.println(accounts[i].toString());
            total += accounts[i].getBalance();
        }
        System.out.println("Total of all accounts: $" + total);
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        BankProgram bank = new BankProgram(10);
        
        bank.addAccount(new Account("Andrew Smith", 100.00));

        
        System.out.print("Enter your name: ");
        String userName = scan.nextLine();
        

        Account currentAccount = bank.find(userName);
        
        if (currentAccount == null) {
            System.out.println("No account found for " + userName);
            scan.close();
            return;
        }

        currentAccount.showBalance();
        
        boolean running = true;
        while (running) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show my balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount: ");
                    double depositAmount = scan.nextDouble();
                    scan.nextLine();
                    currentAccount.deposit(depositAmount);
                    break;
                    
                case 2:
                    System.out.print("Enter the amount: ");
                    double withdrawAmount = scan.nextDouble();
                    scan.nextLine(); 
                    currentAccount.withdraw(withdrawAmount);
                    break;
                    
                case 3:
                    currentAccount.showBalance();
                    break;
                    
                case 4:
                    running = false;
                    bank.printTotal();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
                    break;
            }
        }
        
        scan.close();
    }
}