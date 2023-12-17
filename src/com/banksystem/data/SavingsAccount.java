package com.banksystem.data;

import java.time.LocalDate;

import com.banksystem.repository.Repository;

public class SavingsAccount extends Account {
    int moneyWithdrawalLimit;

    public SavingsAccount(String name, int age, String password) {
        super(name, age, password);
        this.moneyWithdrawalLimit = 10000;
        this.interestRate = 5.0;
    }

    public SavingsAccount(String id, String name, int age, String password, double balance, double interestRate,
            LocalDate createdAt, LocalDate updatedAt) {
        super(id, name, age, password, balance, interestRate, createdAt, updatedAt);
        this.moneyWithdrawalLimit = 10000;
    }

    @Override
    public double withdraw(double amount) {
        // example ni sa polymorphism kay mag override ka sa method sa parent class
        // (Account) para sa SavingsAccount class na naay lain functionality sa withdraw
        // kay sa nabasahan nako usually naay withdraw limit ang savings account na
        // gihatag ang bank para mas maka save ka and kato mag tubo lang na
        int totalWithdrawAmount = 0;

        int differenceInMonths = getDifferenceInMonths();

        // reset every month
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
        // update and interest every transaction
        updateInterest();
        super.addTransaction(type, amount);
    }

    // updateInterest method to update the balance (kay sa bank na akong nabasahan
    // kay mag tubo imong money imo lang ibilin sa bank even pag savings)
    private double updateInterest() {

        // if the difference in months is greater than 1, update the balance and
        // update the updated_at
        if (getDifferenceInMonths() > 1) {
            this.updated_at = LocalDate.now();
            return this.balance += (this.balance * (interestRate * getDifferenceInMonths()));
        }

        return this.balance;
    }

    private int getDifferenceInMonths() {
        int difference = 0;

        // get the last updated month and year
        int last_updated_year = this.updated_at.getYear();
        int last_updated_month = this.updated_at.getMonthValue();
        LocalDate currentDate = LocalDate.now();

        // get the difference in months from the last updated month and year to the
        // current month and year para ma compute kung ikapila na ka months na wala na
        // update ang interest. need ni siya na ing-ani pag compute kay di nato mahimo
        // na automatic ang pag compute so dapat every transaction nalang na i-update
        // ang interest
        int differenceInYear = (currentDate.getYear() - last_updated_year) * 12;
        difference = ((currentDate.getMonthValue() + differenceInYear) - last_updated_month) + 1;

        return difference;
    }

    @Override
    public double getBalance() {
        updateInterest();
        return super.getBalance();
    }

}
