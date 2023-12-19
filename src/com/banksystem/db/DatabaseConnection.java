package com.banksystem.db;

import java.sql.*;

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

                // Create the accounts and transactions tables if they don't exist
                String accountTableQuery = "CREATE TABLE IF NOT EXISTS accounts (" +
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

                String transactionTableQuery = "CREATE TABLE IF NOT EXISTS transactions (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "account_id INT NOT NULL, " +
                        "transaction_type VARCHAR(255) NOT NULL, " +
                        "amount INT NOT NULL, " +
                        "created_at DATE NOT NULL, " +
                        "PRIMARY KEY (id), " +
                        "FOREIGN KEY (account_id) REFERENCES accounts(id)" +
                        ")";

                try (PreparedStatement statement1 = connection.prepareStatement(accountTableQuery);
                        PreparedStatement statement2 = connection.prepareStatement(transactionTableQuery)) {
                    statement1.executeUpdate();
                    statement2.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // get the Singleton instance
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // get the Database Connection
    public Connection getConnection() {
        return connection;
    }

    // close the connection when needed
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
