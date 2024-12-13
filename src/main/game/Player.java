package main.game;

import java.util.Date;

public class Player {

    private String userName;
    private int score = 0;
    private String joinDate;
    private String email;

    public Player(String userName, int score, String joinDate, String email) {
        this.setUserName(userName);
        this.setScore(score);
        this.setJoinDate(joinDate);
        this.setEmail(email);
    }

    public Player(String userName, String joinDate, String email) {
        this.setUserName(userName);
        this.setJoinDate(joinDate);
        this.setEmail(email);
    }

    // GETTERS
    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }
    public String getJoinDate() {
        return joinDate;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("""
                Player's name: %s
                Player's email: %s
                Player's score: %d
                Player's join date: %s'
                """, userName, email, score, joinDate);
    }
}
