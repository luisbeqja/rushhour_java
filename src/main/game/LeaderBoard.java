package main.game;

public class LeaderBoard {

    private Player[] players;


    public LeaderBoard(Player[] players) {
        this.setPlayers(players);
    }
    public LeaderBoard(Player players) {
        this.setPlayers(players);
    }


    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void setPlayers(Player players) {
        this.players = new Player[]{players};
    }
}
