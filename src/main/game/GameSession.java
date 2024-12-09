package main.game;

public class GameSession {

    private int totalTurns = 0;
    private String  startDate = "";
    private String  endDate = "";


    public GameSession( int totalTurns, String startDate, String endDate ) {
        this.setTotalTurns(totalTurns);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
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


    //SETTERS
    public void setTotalTurns(int totalTurns) {
        this.totalTurns = totalTurns;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
