package Structs;

import java.util.ArrayList;

import Interfaces.projectConstants.MomioType;

public class finalSingleMultipleComplexBet implements Comparable<finalSingleMultipleComplexBet> {
    final private double priority;
    final private double momio;
    final private MomioType momioType;
    private double investment;
    final private betHouse betHouse;
    final private String combination_code;
    final private ArrayList<complexBetIndvEntry> allTheSelectedEvents;

    public finalSingleMultipleComplexBet(double priority, double momio, MomioType momioType, betHouse betHouse,
            String combination_code, ArrayList<complexBetIndvEntry> allTheSelectedEvents) {
        this.priority = priority;
        this.momio = momio;
        this.momioType = momioType;
        this.betHouse = betHouse;
        this.combination_code = combination_code;
        this.allTheSelectedEvents = allTheSelectedEvents;
    }

    @Override
    public String toString() {
        return "{" +
                " priority='" + getPriority() + "'" +
                ", momio='" + getMomio() + "'" +
                ", momioType='" + getMomioType() + "'" +
                ", betHouse='" + getBetHouse() + "'" +
                ", combination_code='" + getCombination_code() + "'" +
                ", allTheSelectedEvents='" + getAllTheSelectedEvents() + "'" +
                "}";
    }

    public double getPriority() {
        return this.priority;
    }

    public double getMomio() {
        return this.momio;
    }

    public MomioType getMomioType() {
        return this.momioType;
    }

    public betHouse getBetHouse() {
        return this.betHouse;
    }

    public String getCombination_code() {
        return this.combination_code;
    }

    public ArrayList<complexBetIndvEntry> getAllTheSelectedEvents() {
        return this.allTheSelectedEvents;
    }

    public double getInvestment() {
        return this.investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    @Override
    public int compareTo(finalSingleMultipleComplexBet o) {

        return this.priority < o.priority ? 1 : -1;
    }

}
