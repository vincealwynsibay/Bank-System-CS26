package com.banksystem.data;

import java.time.LocalDate;

public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private LocalDate created_at;

    public Transaction(TransactionType type, double amount) {
        this.transactionType = type;
        this.amount = amount;
        this.created_at = LocalDate.now();
    }

    public Transaction(TransactionType type, double amount, LocalDate createdAt) {
        this.transactionType = type;
        this.amount = amount;
        this.created_at = createdAt;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getCreatedAt() {
        return this.created_at;
    }

    public String toString() {
        return this.transactionType + " " + this.amount + " " + this.created_at;
    }
}
