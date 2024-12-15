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

    // Method to validate email using character checks
    private boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        // Check if there is exactly one '@'
        if (atIndex == -1 || email.indexOf('@', atIndex + 1) != -1) {
            return false; // No '@' or more than one '@'
        }

        // Check if there's at least one character before '@'
        if (atIndex == 0) {
            return false; // '@' is the first character
        }

        // Split into local and domain parts
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Check if there's at least one character in domain part
        if (domainPart.isEmpty()) {
            return false; // No characters after '@'
        }

        // Check for a dot in the domain part
        int dotIndex = domainPart.indexOf('.');
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == domainPart.length() - 1) {
            return false; // No '.' in the domain, or '.' is at the start/end of domain
        }

        // Validate characters in local part
        for (char c : localPart.toCharArray()) {
            if (!isValidLocalChar(c)) {
                return false; // Invalid character in local part
            }
        }

        // Validate characters in domain part
        for (char c : domainPart.toCharArray()) {
            if (!isValidDomainChar(c)) {
                return false; // Invalid character in domain part
            }
        }

        return true; // All checks passed, the email is valid
    }

    // Helper method to check valid characters in the local part of the email
    private boolean isValidLocalChar(char c) {
        // Valid characters for local part
        return Character.isLetterOrDigit(c) || c == '+' || c == '_' || c == '.' || c == '-';
    }

    // Helper method to check valid characters in the domain part of the email
    private boolean isValidDomainChar(char c) {
        // Valid characters for domain part
        return Character.isLetterOrDigit(c) || c == '.' || c == '-';
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