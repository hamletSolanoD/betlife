package Structs;

public class indvBet {
    private String betEventName;
    private betHouse betHouse;
    private int favoritePlayer;// the player that is selected to be the winner
    private String player1Name;
    private String player2Name;
    private double player1Prob;/// The base will be only in decimal momio
    private double player2Prob;/// The base will be only in decimal momio

    @Override
    public String toString() {
        return "{" +
                " betEventName='" + getBetEventName() + "'" +
                ", betHouse='" + getBetHouse() + "'" +
                ", favoritePlayer='" + getFavoritePlayer() + "'" +
                ", player1Name='" + getPlayer1Name() + "'" +
                ", player2Name='" + getPlayer2Name() + "'" +
                ", player1Prob='" + getPlayer1Prob() + "'" +
                ", player2Prob='" + getPlayer2Prob() + "'" +
                "}";
    }

    public indvBet(String betEventName, betHouse betHouse, int favoritePlayer, String player1Name, String player2Name,
            double player1Prob, double player2Prob) {
        this.betEventName = betEventName;
        this.betHouse = betHouse;
        this.favoritePlayer = favoritePlayer;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Prob = player1Prob;
        this.player2Prob = player2Prob;
    }

    public indvBet(String betEventName, String player1Name, String player2Name, int favoritePlayer) {
        this.betEventName = betEventName;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.favoritePlayer = favoritePlayer;

    }

    public String getBetEventName() {
        return this.betEventName;
    }

    public void setBetEventName(String betEventName) {
        this.betEventName = betEventName;
    }

    public betHouse getBetHouse() {
        return this.betHouse;
    }

    public void setBetHouse(betHouse betHouse) {
        this.betHouse = betHouse;
    }

    public int getFavoritePlayer() {
        return this.favoritePlayer;
    }

    public void setFavoritePlayer(int favoritePlayer) {
        this.favoritePlayer = favoritePlayer;
    }

    public String getPlayer1Name() {
        return this.player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return this.player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public double getPlayer1Prob() {
        return this.player1Prob;
    }

    public void setPlayer1Prob(double player1Prob) {
        this.player1Prob = player1Prob;
    }

    public double getPlayer2Prob() {
        return this.player2Prob;
    }

    public void setPlayer2Prob(double player2Prob) {
        this.player2Prob = player2Prob;
    }
}