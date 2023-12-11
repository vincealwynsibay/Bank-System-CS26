package com.banksystem.data;

public class Transaction {
    private TransactionType transactionType;
    private double amount;

    public Transaction(TransactionType type, double amount) {
        this.transactionType = type;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public double getAmount() {
        return this.amount;
    }
}
