package com.banksystem.data;

import com.banksystem.repository.Repository;

import java.time.LocalDate;

public class Account extends Person {
    protected String id;
    protected String password;
    protected double balance;
    protected double interestRate;
    protected LocalDate created_at;
    protected LocalDate updated_at;

    // Account constructor
    public Account(String name, int age, String password) {
        super(name, age);

        this.password = password;
        this.balance = 0;
        this.interestRate = 0.025;

        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
    }

    // Account constructor with ID for the database account row
    public Account(String id, String name, int age, String password, double balance, double interestRate,
            LocalDate createdAt, LocalDate updatedAt) {
        super(name, age);

        this.id = id;
        this.password = password;
        this.balance = balance;
        this.interestRate = interestRate;

        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }

    // withdraw money from the Account
    public double withdraw(double amount) {
        // If the balance is less than 0, return -1
        if ((this.balance - amount) < 0) {
            return -1;
        }

        // add withdraw Transaction to the Transactions Table
        double newBalance = this.balance - amount;
        setBalance(newBalance);

        addTransaction(TransactionType.WITHDRAW, -amount);
        return this.balance;
    }

    // deposit money to the Account
    public void deposit(double amount) {
        double newBalance = this.balance + amount;
        setBalance(newBalance);

        addTransaction(TransactionType.DEPOSIT, amount);
    }

    // decrease the balance of the Account and add a transfer transaction to the
    // Transactions Table (used for adding a new Transaction)
    public double transferMoney(double amount) {
        if ((this.balance - amount) < 0) {
            return -1;
        }

        double newBalance = this.balance - amount;
        setBalance(newBalance);

        addTransaction(TransactionType.TRANSFER, -amount);
        return this.balance;
    }

    // increase the balance of the Account and add a receive transaction to the
    // Transactions Table (used for adding a new Transaction)
    public void receiveMoney(double amount) {
        double newBalance = this.balance + amount;
        setBalance(newBalance);
        addTransaction(TransactionType.RECEIVE, amount);
    }

    // creates a new Transaction and adds it to the Transactions Table
    protected void addTransaction(TransactionType type, double amount) {
        this.updated_at = LocalDate.now();
        Transaction newTransaction = new Transaction(type, amount);
        this.updated_at = LocalDate.now();

        Repository repository = Repository.getInstance();
        repository.addTransaction(this.getId(), newTransaction);
    }

    // getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreatedAt() {
        return this.created_at;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return this.balance;
    }

    // setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

}