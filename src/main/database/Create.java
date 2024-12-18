package main.database;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    //create player table
    public void createPlayersTable() throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        statement.executeUpdate("""
            CREATE TABLE IF NOT EXISTS players (
                player_id SERIAL
                    CONSTRAINT pk_player PRIMARY KEY,
                player_name VARCHAR(50) NOT NULL,
                join_date DATE,
                email VARCHAR(50) NOT NULL
            );
        """);
        System.out.println("Player table created successfully.");
    }
    //create sessions table
    public void createSessionsTable() throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        statement.executeUpdate(""" 
            CREATE TABLE IF NOT EXISTS sessions (
                            sessions_id NUMERIC(4) PRIMARY KEY,
                            player_id INTEGER REFERENCES players(player_id),
                            start_date TIMESTAMP NOT NULL,
                            end_date TIMESTAMP NOT NULL,
                            total_turns NUMERIC(4) NOT NULL,
                            score NUMERIC(4) NOT NULL,
                            difficulty VARCHAR(6) CHECK (difficulty IN ('easy', 'medium', 'hard')) NOT NULL,
                            duration INTERVAL NOT NULL
                        );
            """);
        System.out.println("Sessions table created successfully.");
    }

    //Create boards states table
    public void createBoardstatesTable() throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        statement.executeUpdate("""
CREATE TABLE IF NOT EXISTS boardstates (
                session_id NUMERIC(4) REFERENCES sessions(sessions_id),
                game_row NUMERIC(1) CHECK (game_row BETWEEN 1 AND 6),
                game_column NUMERIC(1) CHECK (game_column BETWEEN 1 AND 6),
                cell_value VARCHAR(1) CHECK (cell_value IN ('0', 'A', 'B', 'C', 'D', 'E', 'F', 'X')) NOT NULL,
                PRIMARY KEY (session_id, game_row, game_column)
                                       );
""");
        System.out.println("Boardstates table created successfully.");
    }
}