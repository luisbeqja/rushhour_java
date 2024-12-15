package main.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDDL {
// TEST DATABASE CONNECTION
//    DatabaseConnection.getConnection();
//    Create create = new Create();
//    create.createPlayerTable();
//
//    //Create a statement
//    Statement statement = connection.createStatement();
//
//    //Creating a table
//    statement.executeUpdate()

public static void executeDDL(Connection connection) { //Modify following string in future if edits needed
String createTablesSQL = """
        -- creating a players table
        DROP TABLE IF EXISTS players;
        CREATE TABLE IF NOT EXISTS players (
            player_id INTEGER
                CONSTRAINT pk_player PRIMARY KEY,
            player_name VARCHAR(10) NOT NULL,
            join_date DATE
                CONSTRAINT ch_players_join_date CHECK (join_date <= '2024-12-5'),
            email VARCHAR(50) NOT NULL
        );
        
        -- Creating sessions table
        DROP TABLE IF EXISTS sessions;
        CREATE TABLE IF NOT EXISTS sessions (
            sessions_id NUMERIC(4)
                CONSTRAINT pk_sessions PRIMARY KEY,
            player_id INTEGER
                CONSTRAINT fk_sessions_player_id
                    REFERENCES players(player_id),
            start_date TIMESTAMP NOT NULL,
            end_date TIMESTAMP NOT NULL,
            total_turns NUMERIC(4) NOT NULL,
            score NUMERIC(4) NOT NULL,
            -- easy, medium, hard
            difficulty VARCHAR(6) NOT NULL
                CONSTRAINT ch_sessions_difficulty
                    CHECK (difficulty IN ('easy', 'medium', 'hard')),
            duration INTERVAL NOT NULL
        );
        
        -- creating  boardstates table
        DROP TABLE IF EXISTS boardstates;
        CREATE TABLE IF NOT EXISTS boardstates (
            session_id NUMERIC(4)
                CONSTRAINT fk_boardstates_session_id
                    REFERENCES sessions(sessions_id),
            game_row NUMERIC(1)
                CONSTRAINT ch_boardstates_row
                    CHECK (game_row BETWEEN 1 AND 6),
            game_column NUMERIC(1)
                CONSTRAINT ch_boardstates_column
                    CHECK (game_column BETWEEN 1 AND 6),
            CONSTRAINT pk_boardstates
                PRIMARY KEY (session_id, game_row, game_column),
            -- 0 OR A,B,C...X
            cell_value VARCHAR(1) NOT NULL
                CONSTRAINT ch_boardstates_cell_value
                    CHECK (cell_value IN ('0','A','B','C','D','E','F','X'))
        );
        """;
//Execute the SQL script
try (Statement statement = connection.createStatement()) {
    statement.execute(createTablesSQL);
} catch (SQLException e) {
    System.err.println("Error while executing DDL: " + e.getMessage());
}
}



}
