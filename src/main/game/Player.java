package main.game;

public class Player {

    private String userName;
    private int score;

    public Player( String userName, int score) {
        this.setUserName(userName);
        this.setScore(score);
    }

    // GETTERS
    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
