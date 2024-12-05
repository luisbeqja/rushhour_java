package main.database;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    private Statement createStatement() {
        try {
            return DatabaseConnection.getConnection().createStatement();
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!" + e.getMessage());
            return null;
        }
    }

    public void createPlayerTable() throws SQLException {
        Statement statement = createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS"
                + " players (player_name VARCHAR(10),"
                + "          join_date DATE,"
                + "          email VARCHAR(50))");
    }
}
