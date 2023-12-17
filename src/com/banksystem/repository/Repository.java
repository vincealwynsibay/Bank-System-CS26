package com.banksystem.repository;

import java.util.ArrayList;
import com.banksystem.data.Account;
import com.banksystem.data.SavingsAccount;
import com.banksystem.data.TransactionType;
import com.banksystem.db.DatabaseConnection;

public class Repository {
    private static Repository instance;

    private Account currentAccount = null;
    // private ArrayList<Account> accounts;

    public Repository() {
        // this.accounts = new ArrayList<Account>();
        // Account account = new Account("admin", 0, "admin");
        // SavingsAccount account2 = new SavingsAccount("admin2", 0, "admin2");
        // accounts.add(account);
        // accounts.add(account2);
    }

    public boolean login(String name, String password) {

        DatabaseConnection db = DatabaseConnection.getInstance();
        Account account = db.getAccount(name);

        if (account != null && account.getPassword().equals(password)) {
            currentAccount = account;
            return true;
        }

        return false;
    }

    public void register(String name, int age, String password, String accountType) {
        // create account class and add to database
        DatabaseConnection db = DatabaseConnection.getInstance();
        Account account;

        if (accountType.toUpperCase().equals("SAVINGS")) {
            account = new SavingsAccount(name, age, password);
        } else {
            account = new Account(name, age, password);
        }

        db.insertAccount(account);
    }

    public void logoutUser() {
        currentAccount = null;
    }

    // transfer money

    // receive money

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

}
