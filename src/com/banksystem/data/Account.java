package com.banksystem.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDate;

public class Account extends Person {
    protected String accountId;
    protected String password;
    protected double balance;
    protected double interestRate;

    protected LocalDate created_at;
    protected LocalDate updated_at;

    protected ArrayList<Transaction> transactions;

    public static int numOfAccount;

    public Account(String name, int age, String password) {
        super(name, age);

        this.accountId = generateAccountId();
        this.password = password;
        this.balance = 0;
        this.interestRate = 0.025;

        // sets created at and update at in (MONTH)(DAY)(YEAR) Format and if the day or
        // month is less than 10, it adds a 0 in front of it (ex. 9 -> 09)
        // Calendar cal = Calendar.getInstance();
        // this.created_at = formatDate(cal.get(cal.MONTH)) +
        // formatDate(cal.get(cal.DAY_OF_MONTH));
        // this.updated_at = formatDate(cal.get(cal.MONTH)) +
        // formatDate(cal.get(cal.DAY_OF_MONTH))
        // + String.valueOf(cal.get(cal.YEAR));

        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();

        this.transactions = new ArrayList<>();
        // this.loans = new ArrayList<>();
    }

    // 6 digits number (if single digit pad 5 zeros in front of it)
    public String generateAccountId() {
        numOfAccount++;
        String accountId = String.valueOf(numOfAccount);

        while (accountId.length() < 6) {
            accountId = "0" + accountId;
        }

        return accountId;
    }

    public static Account getAccount(String userId) {
        Account account = new Account(userId, 0, "");

        return account;
    }

    // WITHDRAW money from the account
    public double withdraw(double amount) {
        // if the balance is less than 0, return -1
        if ((this.balance - amount) < 0) {
            return -1;
        }

        // addTransaction method for the transactions list refer below for more info
        addTransaction(TransactionType.WITHDRAW, amount);
        this.balance -= amount;

        return this.balance;
    }

    // DEPOSIT money to the account
    public void deposit(double amount) {
        this.balance += amount;
        addTransaction(TransactionType.DEPOSIT, amount);
    }

    // LOAN money from the bank
    // public void loan(int amount) {
    // // uses the Loan class static method to check if the user can loan the amount
    // if (Loan.getAvailableLoanAmount(created_at) > amount) {
    // Loan newLoan = new Loan(amount, 1.5);
    // this.loans.add(newLoan);
    // this.balance += amount;
    // addTransaction(TransactionType.LOAN, amount);
    // }
    // }

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
        this.transactions.add(newTransaction);
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

    public String getAccountId() {
        return this.accountId;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public LocalDate getCreatedAt() {
        // month / day / year
        return this.created_at;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}