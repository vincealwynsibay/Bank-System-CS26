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

    public Account(String name, int age, String password) {
        super(name, age);

        this.password = password;
        this.balance = 0;
        this.interestRate = 0.025;

        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
    }

    // para ni siya sa pag load usab sa account gikan sa database
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

    // WITHDRAW money from the account
    public double withdraw(double amount) {
        // if the balance is less than 0, return -1
        if ((this.balance - amount) < 0) {
            return -1;
        }

        // addTransaction method for the transactions list refer below for more info
        addTransaction(TransactionType.WITHDRAW, -amount);
        this.balance -= amount;

        return this.balance;
    }

    // DEPOSIT money to the account
    public void deposit(double amount) {
        this.balance += amount;
        addTransaction(TransactionType.DEPOSIT, amount);
    }

    public double transferMoney(double amount) {

        if ((this.balance - amount) < 0) {
            return -1;
        }

        this.balance -= amount;

        addTransaction(TransactionType.TRANSFER, -amount);
        return this.balance;
    }

    // RECEIVE money from another account (acts like deposit but this is made for
    // transactions list purposes)
    public void receiveMoney(double amount) {
        this.balance += amount;
        addTransaction(TransactionType.RECEIVE, amount);
    }

    // add a transaction. this uses the TransactionType Enum to determine what type
    // of transaction it is. Mura siyag String gihapon ang enum pero limited lang
    // siya sa kung unsa na gi define sa enum na mga values like sa transaction type
    // kay withdraw, deposit, etc lang dapat bawal na Name or something
    protected void addTransaction(TransactionType type, double amount) {
        this.updated_at = LocalDate.now();
        Transaction newTransaction = new Transaction(type, amount);

        // update record after every transactions (the balance and the
        // transactions list)
        Repository repository = Repository.getInstance();
        repository.addTransaction(this.getId(), newTransaction);
    }

    // format the date to (MONTH)(DAY)(YEAR) Format and if the day or month is less
    // than 10, it adds a 0 in front of it (ex. 9 -> 09)
    protected String formatDate(int num) {
        if (num > 9) {
            return String.valueOf(num);
        } else {

            return "0" + String.valueOf(num);
        }
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreatedAt() {
        // month / day / year
        return this.created_at;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}