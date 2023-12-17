package com.banksystem.repository;

import java.util.ArrayList;

import java.sql.*;

import com.banksystem.data.Account;
import com.banksystem.data.SavingsAccount;
import com.banksystem.data.Transaction;
import com.banksystem.data.TransactionType;
import com.banksystem.db.DatabaseConnection;

public class Repository {
    private static Repository instance;

    private Account currentAccount = null;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public boolean login(String name, String password) {

        Account account = getAccount(name);

        if (account != null && account.getPassword().equals(password)) {
            currentAccount = account;
            return true;
        }

        return false;
    }

    public boolean register(String name, int age, String password, String accountType) {
        // create account class and add to database
        Account account;

        if (accountType.toUpperCase().equals("SAVINGS")) {
            account = new SavingsAccount(name, age, password);
        } else {
            account = new Account(name, age, password);
        }

        if (getAccount(name) == null) {
            insertAccount(account);
            return true;
        }
        return false;
    }

    public void logoutUser() {
        currentAccount = null;
    }

    public void transfer(String toAccountName, double amount) {
        Account fromAccount = getCurrentAccount();
        Account toAccount = getAccount(toAccountName);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Account not found");
            return;
        }

        fromAccount.transferMoney(amount);
        toAccount.receiveMoney(amount);
    }

    public ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();

            // SQL query for selection
            String sql = "SELECT * FROM transactions WHERE account_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, this.getCurrentAccount().getId());

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        String transactionType = resultSet.getString("transaction_type");
                        double amount = resultSet.getDouble("amount");
                        Date createdAt = resultSet.getDate("created_at");

                        Transaction transaction = new Transaction(TransactionType.valueOf(transactionType),
                                amount, createdAt.toLocalDate());

                        transactions.add(transaction);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }

        return transactions;
    }

    public int getNumberOfAccounts() {
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();

            // SQL query for selection
            String sql = "SELECT COUNT(*) FROM accounts";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Process the result set
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }

        return 0;
    }

    public Account getAccount(String name) {
        // fetch from database and compare similar name
        try {
            // SQL query for selection
            String sql = "SELECT * FROM accounts WHERE name = ?";

            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Process the result set
                    if (resultSet.next()) {
                        String id = resultSet.getString("id");
                        String accountName = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String password = resultSet.getString("password");
                        double balance = resultSet.getDouble("balance");
                        String type = resultSet.getString("type");
                        double interestRate = resultSet.getDouble("interestRate");
                        Date createdAt = resultSet.getDate("created_at");
                        Date updatedAt = resultSet.getDate("updated_at");

                        if (type.equals("SAVINGS")) {
                            return new SavingsAccount(id, accountName, age, password, balance,
                                    interestRate,
                                    createdAt.toLocalDate(), updatedAt.toLocalDate());
                        }
                        return new Account(id, accountName, age, password, balance,
                                interestRate,
                                createdAt.toLocalDate(), updatedAt.toLocalDate());
                    }

                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
            return null;
        }
    }

    public void insertAccount(Account newAccount) {
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();

            String sql = "INSERT INTO accounts (name, age, password, balance, type, interestRate, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newAccount.getName());
                statement.setInt(2, newAccount.getAge());
                statement.setString(3, newAccount.getPassword());
                statement.setDouble(4, newAccount.getBalance());

                // check if newAccount is instanceOf savings account
                if (newAccount instanceof SavingsAccount) {
                    statement.setString(5, "SAVINGS");
                } else {
                    statement.setString(5, "CHECKING");
                }

                statement.setDouble(6, newAccount.getInterestRate());
                statement.setDate(7, Date.valueOf(newAccount.getCreatedAt()));
                statement.setDate(8, Date.valueOf(newAccount.getCreatedAt()));

                // Execute the query
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBalance(double amount, String id) {
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();

            String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, amount);
                statement.setString(2, id);

                // Execute the query
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

    public void addTransaction(String account_id, Transaction newTransaction) {
        try {
            System.out.println(
                    "Adding transaction" + newTransaction.getTransactionType() + " - " + newTransaction.getAmount());

            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection connection = db.getConnection();

            // SQL query for insert
            String sql = "INSERT INTO transactions (account_id, transaction_type, amount, created_at) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, account_id);
                statement.setString(2, newTransaction.getTransactionType().toString());
                statement.setDouble(3, newTransaction.getAmount());
                statement.setDate(4, Date.valueOf(newTransaction.getCreatedAt()));

                // Execute the query
                statement.executeUpdate();

                updateBalance(newTransaction.getAmount(), account_id);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

}
