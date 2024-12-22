package main.game;

import main.database.Leaderboard;
import java.sql.SQLException;
import java.util.List;

public class DisplayLeaderboard {

    private Leaderboard leaderboardQuery;

    public DisplayLeaderboard() {
        leaderboardQuery = new Leaderboard();
    }

    // Method to display the leaderboard for a specific difficulty
    public void displayLeaderboard(String difficulty) {
        try {
            List<String[]> leaderboard = leaderboardQuery.getLeaderboard(difficulty);

            System.out.println("Leaderboard for " + difficulty + " difficulty:");
            System.out.println("Player Name\t\tTotal Score");
            System.out.println("-------------------------------------");
            System.out.println("(Enter 0 to go back to Start Menu.)");

            for (String[] entry : leaderboard) {
                String playerName = entry[0];
                String totalScore = entry[1];
                System.out.printf("%-20s\t%s%n", playerName, totalScore);
            }

            System.out.println();

        } catch (SQLException e) {
            System.err.println("Error fetching leaderboard data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

