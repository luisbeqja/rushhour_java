package main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection connection;

    // PostgresSQL connection string
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres"; // Path to your database file
    private static final String USER = "postgres"; // Default PostgresSQL user


    // TODO ASK about the PASSWORD from different pc's
    private static final String PASSWORD = "2532002Luis"; // Default PostgresSQL password (different from every pc)

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Initialize the connection
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connection to PostgresSQL has been established.");

            } catch (SQLException e) {
                System.err.println("Connection to DB failed!" + e.getMessage());
            }
        }
        return connection;
    }
}
