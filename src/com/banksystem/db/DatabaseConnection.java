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

}
