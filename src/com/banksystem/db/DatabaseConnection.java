package com.banksystem.db;

import java.sql.*;

import com.banksystem.data.Account;
import com.banksystem.data.SavingsAccount;
import com.banksystem.data.Transaction;

public class DatabaseConnection {

    // Database connection details
    private static final String driverName = "org.mariadb.jdbc.Driver";
    private static final String databaseUrl = "jdbc:mariadb://localhost:3306/banksystem";
    private static final String username = "root";
    private static final String password = "vince";

    // Singleton instance
    private static DatabaseConnection instance;

    // Connection object
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        try {
            // Load the JDBC driver
            Class.forName(driverName);
            // Establish the database connection
            connection = DriverManager.getConnection(databaseUrl, username, password);

            try {

                if (!tablesExist("accounts") || !tablesExist("transactions")) {
                    String query1 = "CREATE TABLE IF NOT EXISTS accounts (" +
                            "id INT NOT NULL AUTO_INCREMENT, " +
                            "name VARCHAR(255) NOT NULL, " +
                            "age INT NOT NULL, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "balance INT NOT NULL, " +
                            "type VARCHAR(255) NOT NULL, " +
                            "interestRate DOUBLE NOT NULL, " +
                            "created_at DATE NOT NULL, " +
                            "updated_at DATE NOT NULL, " +
                            "PRIMARY KEY (id)" +
                            ")";

                    String query2 = "CREATE TABLE IF NOT EXISTS transactions (" +
                            "id INT NOT NULL AUTO_INCREMENT, " +
                            "account_id INT NOT NULL, " +
                            "transaction_type VARCHAR(255) NOT NULL, " +
                            "amount INT NOT NULL, " +
                            "created_at DATE NOT NULL, " +
                            "PRIMARY KEY (id), " +
                            "FOREIGN KEY (account_id) REFERENCES accounts(id)" +
                            ")";

                    try (PreparedStatement statement1 = connection.prepareStatement(query1);
                            PreparedStatement statement2 = connection.prepareStatement(query2)) {
                        // Execute the queries
                        statement1.executeUpdate();
                        statement2.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle exceptions appropriately in a real application
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

    // Public method to get the singleton instance
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private boolean tablesExist(String tableName) throws SQLException {
        DatabaseMetaData metadata = connection.getMetaData();
        try (ResultSet resultSet = metadata.getTables(null, null, tableName, null)) {
            return resultSet.next();
        }
    }

    // Public method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Close the connection when needed
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

    public Account getAccount(String name) {
        // fetch from database and compare similar name
        try {
            // SQL query for selection
            String sql = "SELECT * FROM accounts WHERE name = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Process the result set
                    if (resultSet.next()) {
                        String accountId = resultSet.getString("id");
                        String accountName = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String password = resultSet.getString("password");
                        double balance = resultSet.getDouble("balance");
                        String type = resultSet.getString("type");
                        double interestRate = resultSet.getDouble("interestRate");
                        Date createdAt = resultSet.getDate("created_at");
                        Date updatedAt = resultSet.getDate("updated_at");

                        if (type.equals("SAVINGS")) {
                            return new SavingsAccount(accountId, accountName, age, password, balance,
                                    interestRate,
                                    createdAt.toLocalDate(), updatedAt.toLocalDate());
                        }
                        return new Account(accountId, accountName, age, password, balance,
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
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

    public void updateBalance(double amount, String accountId) {
        try {
            // subtract balance with amount
            String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, amount);
                statement.setString(2, accountId);

                // Execute the query
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

    public void addTransaction(String accountId, Transaction newTransaction) {
        try {
            // SQL query for insert
            String sql = "INSERT INTO transactions (account_id, transaction_type, amount, created_at) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, accountId);
                statement.setString(2, newTransaction.getTransactionType().toString());
                statement.setDouble(3, newTransaction.getAmount());
                statement.setDate(4, Date.valueOf(newTransaction.getCreatedAt()));

                // Execute the query
                statement.executeUpdate();

                updateBalance(newTransaction.getAmount(), accountId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }
    }

}
