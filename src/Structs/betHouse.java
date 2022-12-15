package Structs;

import Interfaces.projectConstants.MomioType;

public class betHouse {
    private String betHouseName;
    private String betHouseLink;
    private double totalMoneyAmount;
    private MomioType momioType;

    public betHouse(String betHouseName, String betHouseLink, double totalMoneyAmount, MomioType momioType) {
        this.betHouseName = betHouseName;
        this.betHouseLink = betHouseLink;
        this.totalMoneyAmount = totalMoneyAmount;
        this.momioType = momioType;
    }

    public void setMomioType(MomioType momioType) {
        this.momioType = momioType;
    }

    public String getBetHouseName() {
        return this.betHouseName;
    }

    public void setBetHouseName(String betHouseName) {
        this.betHouseName = betHouseName;
    }

    @Override
    public String toString() {
        return "{" +
                " betHouseName='" + getBetHouseName() + "'" +
                ", betHouseLink='" + getBetHouseLink() + "'" +
                ", totalMoneyAmount='" + getTotalMoneyAmount() + "'" +
                ", momioType='" + getMomioType() + "'" +
                "}";
    }

    public String getBetHouseLink() {
        return this.betHouseLink;
    }

    public void setBetHouseLink(String betHouseLink) {
        this.betHouseLink = betHouseLink;
    }

    public double getTotalMoneyAmount() {
        return this.totalMoneyAmount;
    }

    public void setTotalMoneyAmount(double totalMoneyAmount) {
        this.totalMoneyAmount = totalMoneyAmount;
    }

    public MomioType getMomioType() {
        return this.momioType;
    }

    public String getbetHouseName() {
        return this.betHouseName;
    }

    public void setbetHouseName(String betHouseName) {
        this.betHouseName = betHouseName;
    }

    public String getbetHouseLink() {
        return this.betHouseLink;
    }

    public void setbetHouseLink(String betHouseLink) {
        this.betHouseLink = betHouseLink;
    }

    public double getTotalMonetAmount() {
        return this.totalMoneyAmount;
    }

    public void setTotalMonetAmount(float totalMonetAmount) {
        this.totalMoneyAmount = totalMonetAmount;
    }

}
