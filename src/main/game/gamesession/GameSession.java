package main.game.gamesession;

public class GameSession {

    private int totalTurns = 0;
    private String startDate = "";
    private String endDate = "";
    private String score = "";
    private String difficulty = "";
    private String duration = "";
    private String sessionId = "";
    private String playerId = "";


    public GameSession( String startDate, String endDate, String totalTurns, String score, String difficulty, String duration, String sessionId, String playerId ) {
        this.setTotalTurns(totalTurns);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setScore(score);
        this.setDifficulty(difficulty);
        this.setDuration(duration);
        this.setSessionId(sessionId);
        this.setPlayerId(playerId);
    }

    //GETTERS
    public int getTotalTurns() {
        return totalTurns;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getScore() {
        return score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getDuration() {
        return duration;
    }

    public String getPlayerId() {
        return playerId;
    }


    //SETTERS
    public void setTotalTurns(String totalTurns) {
        this.totalTurns = Integer.parseInt(totalTurns);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
