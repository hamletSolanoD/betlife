package Structs;

import Interfaces.projectConstants.MomioType;

public class complexBetIndvEntry extends indvBet {

    private String winnerPlayer;
    private float winnerPlayerMomio;
    private MomioType winnerMomioType;
    private double priority;
    private double momio;

    @Override
    public String toString() {
        return "{" +
                " winnerPlayer='" + getWinnerPlayer() + "'" +
                ", winnerPlayerMomio='" + getWinnerPlayerMomio() + "'" +
                ", winnerMomioType='" + getWinnerMomioType() + "'" +
                ", priority='" + getPriority() + "'" +
                ", momio='" + getMomio() + "'" +
                "}";
    }

    public complexBetIndvEntry(indvBet originalBetEvent) {
        super(originalBetEvent.getBetEventName(), originalBetEvent.getBetHouse(), originalBetEvent.getFavoritePlayer(),
                originalBetEvent.getPlayer1Name(), originalBetEvent.getPlayer2Name(), originalBetEvent.getPlayer1Prob(),
                originalBetEvent.getPlayer2Prob());

    }

    public double getPriority() {
        return this.priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public double getMomio() {
        return this.momio;
    }

    public void setMomio(double momio) {
        this.momio = momio;
    }

    public complexBetIndvEntry(String betEventName, betHouse betHouse, int favoritePlayer, String player1Name,
            String player2Name,
            double player1Prob, double player2Prob) {
        super(betEventName, betHouse, favoritePlayer, player1Name, player2Name, player1Prob, player2Prob);

    }

    public void setWinnerPlayer(String winnerPlayer, float WinnerPlayerMomio, MomioType winnerPlayerMomioType) {
        this.winnerPlayer = winnerPlayer;
        this.winnerPlayerMomio = WinnerPlayerMomio;
        this.winnerMomioType = winnerPlayerMomioType;

    }

    public String getWinnerPlayer() {
        return this.winnerPlayer;
    }

    public float getWinnerPlayerMomio() {
        return this.winnerPlayerMomio;
    }

    public MomioType getWinnerMomioType() {
        return this.winnerMomioType;
    }

}