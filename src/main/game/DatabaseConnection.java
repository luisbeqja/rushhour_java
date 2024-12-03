package main.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // PostgreSQL connection string
    //TODO: fix DB_URL with real db (check the name of DB)
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/RushHourDatabase"; // Path to your database file
    private static final String USER = "postgres"; // Default PostgreSQL user
    private static final String PASSWORD = ""; // Default PostgreSQL password (empty string)

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Initialize the connection
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connection to PostgreSQL has been established.");
            } catch (SQLException e) {
                System.err.println("Connection to DB failed!");
            }
        }
        return connection;
    }
}
