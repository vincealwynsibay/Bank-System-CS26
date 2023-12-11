package com.banksystem.repository;

import java.util.ArrayList;
import com.banksystem.data.Account;
import com.banksystem.data.TransactionType;

public class Repository {
    private static Repository instance;

    private Account currentAccount = null;
    private ArrayList<Account> accounts;

    public Repository() {
        this.accounts = new ArrayList<Account>();
        Account account = new Account("admin", 0, "admin");
        Account account2 = new Account("admin2", 0, "admin2");
        accounts.add(account);
        accounts.add(account2);
    }

    public boolean login(String accountId, String password) {
        for (Account account : accounts) {
            if (account.getName().equals(accountId) && account.getPassword().equals(password)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public void register(String accountId, int age, String password) {
        Account account = new Account(accountId, age, password);

        // check if accounts list contains accountId
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return;
            }
        }

        accounts.add(account);
    }

    public void logoutUser() {
        currentAccount = null;
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Account getAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    // print accounts
    public void printAccounts() {
        for (Account account : accounts) {
            // print details
            System.out.println(account.getAccountId() + " " + account.getAge() + " " + account.getPassword());
        }
    }
}
