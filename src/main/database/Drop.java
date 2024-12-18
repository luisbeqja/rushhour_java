package main.database;

import java.sql.SQLException;
import java.sql.Statement;

public class Drop {
    //Drop tables
    public void dropTables() throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        statement.executeUpdate("""
            DROP TABLE IF EXISTS boardstates;
            DROP TABLE IF EXISTS sessions;
            DROP TABLE IF EXISTS players;
        """);
    }
}
