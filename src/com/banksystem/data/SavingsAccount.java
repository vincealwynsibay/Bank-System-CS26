package com.banksystem.data;

import java.time.LocalDate;

import com.banksystem.repository.Repository;

public class SavingsAccount extends Account {
    private int moneyWithdrawalLimit;

    // SavingsAccount has a moneyWithdrawalLimit and interestRate for limited
    // withdraw and growing balance

    // SavingsAccount constructor
    public SavingsAccount(String name, int age, String password) {
        super(name, age, password);
        this.moneyWithdrawalLimit = 10000;
        this.interestRate = 5.0;
    }

    // SavingsAccount constructor with ID for the database account row
    public SavingsAccount(String id, String name, int age, String password, double balance, double interestRate,
            LocalDate createdAt, LocalDate updatedAt) {
        super(id, name, age, password, balance, interestRate, createdAt, updatedAt);
        this.moneyWithdrawalLimit = 10000;
    }

    // withdraw money from the SavingsAccount (example of polymorphism)
    @Override
    public double withdraw(double amount) {
        int totalWithdrawAmount = 0;

        int differenceInMonths = getDifferenceInMonths();

        // if the difference in months is greater than 1, reset the
        // moneyWithdrawalLimit
        if (differenceInMonths > 1) {
            this.moneyWithdrawalLimit = 10000;
        }

        // get the total amount of withdraw transactions
        Repository repository = Repository.getInstance();
        for (Transaction transaction : repository.getTransactions()) {
            if (transaction.getTransactionType() == TransactionType.WITHDRAW) {
                totalWithdrawAmount += transaction.getAmount();
            }
        }

        // if the total amount of withdraw transactions is greater than the
        // moneyWithdrawalLimit, add a penalty of 500
        if ((totalWithdrawAmount + amount) > moneyWithdrawalLimit) {
            int penaltyAmount = 500;
            addTransaction(TransactionType.PENALTY, penaltyAmount);
            this.balance -= penaltyAmount;
        }

        return super.withdraw(amount);
    }

    @Override
    protected void addTransaction(TransactionType type, double amount) {
        // update interest every transaction
        updateInterest();
        super.addTransaction(type, amount);
    }

    // updateInterest method to update the balance and updated_at
    private double updateInterest() {

        // if the difference in months is greater than 1, update the balance and
        // update the updated_at
        if (getDifferenceInMonths() > 1) {
            return this.balance += (this.balance * (interestRate * getDifferenceInMonths()));
        }

        return this.balance;
    }

    // get the difference in months from the last updated month and year to the
    // current month and year
    private int getDifferenceInMonths() {
        int difference = 0;

        // get the last updated month and year
        int last_updated_year = this.updated_at.getYear();
        int last_updated_month = this.updated_at.getMonthValue();
        LocalDate currentDate = LocalDate.now();

        // get the difference in months
        int differenceInYear = (currentDate.getYear() - last_updated_year) * 12;
        difference = ((currentDate.getMonthValue() + differenceInYear) - last_updated_month) + 1;

        return difference;
    }

    // get the balance of the SavingsAccount (example of polymorphism)
    @Override
    public double getBalance() {
        updateInterest();
        return super.getBalance();
    }

}
