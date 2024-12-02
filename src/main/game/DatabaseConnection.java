package main.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // HSQLDB connection string
    //TODO: fix DB_URL with real db
    private static final String DB_URL = "jdbc:hsqldb:file:db/myDatabase"; // Path to your database file
    private static final String USER = "sa"; // Default HSQLDB user
    private static final String PASSWORD = ""; // Default HSQLDB password (empty string)

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Initialize the connection
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connection to HSQLDB has been established.");
            } catch (SQLException e) {
                System.err.println("Connection to DB failed!");
            }
        }
        return connection;
    }
}
