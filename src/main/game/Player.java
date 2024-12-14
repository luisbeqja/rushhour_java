package main.game;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

  /*  public Player(String userName, String joinDate, String email) {
        this.setUserName(userName);
        this.setJoinDate(joinDate);
        this.setEmail(email);
    }

   */



    public Player(String userName, String joinDate, String email) {
        // Validate inputs in this constructor
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }

        if (email == null || email.trim().isEmpty() || !isValidEmail(email)) {
            throw new IllegalArgumentException("Email cannot be null, empty, or invalid.");
        }

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

    // Method to validate email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
