package Structs;

import java.util.ArrayList;
import java.util.Collections;

public class multipleBetEntries {
    private ArrayList<ArrayList<complexBetIndvEntry>> allTheCombinationOfEveryPossibleEvent = new ArrayList<ArrayList<complexBetIndvEntry>>();
    private ArrayList<complexBetIndvEntry> IndividualTotalEvents = new ArrayList<complexBetIndvEntry>();
    private ArrayList<finalSingleMultipleComplexBet> allTheCombinationOfEveryPossibleEventWithMomio = new ArrayList<finalSingleMultipleComplexBet>();
    private betHouse ownerHouse;

    public ArrayList<finalSingleMultipleComplexBet> generate_every_combination_by_BetHouse() {
        int generalEventCounter = 1;

        int totalEventsToFill = (int) Math.pow(2, IndividualTotalEvents.size());
        for (complexBetIndvEntry event : IndividualTotalEvents) {
            int limitToChange = (int) Math.pow(2, generalEventCounter);
            boolean playerToSet = true;

            for (int eventCounter = 0; eventCounter < totalEventsToFill; eventCounter++) {
                if (allTheCombinationOfEveryPossibleEvent.size() - 1 < eventCounter) {
                    allTheCombinationOfEveryPossibleEvent.add(eventCounter, new ArrayList<complexBetIndvEntry>());
                }

                complexBetIndvEntry p1Won = new complexBetIndvEntry(event);
                p1Won.setWinnerPlayer(p1Won.getPlayer1Name(), (float) p1Won.getPlayer1Prob(),
                        p1Won.getBetHouse().getMomioType());

                complexBetIndvEntry p2Won = new complexBetIndvEntry(event);
                p2Won.setWinnerPlayer(p2Won.getPlayer2Name(), (float) p2Won.getPlayer2Prob(),
                        p2Won.getBetHouse().getMomioType());

                p1Won.setPriority(100 / generalEventCounter *
                        (p1Won.getFavoritePlayer() == 1 ? 1 : 0));
                p2Won.setPriority(100 / generalEventCounter *
                        (p2Won.getFavoritePlayer() == 2 ? 1 : 0));

                if (((eventCounter + 1) % (totalEventsToFill / limitToChange)) == 0) {
                    playerToSet = !playerToSet;
                }

                if (playerToSet)
                    allTheCombinationOfEveryPossibleEvent.get(eventCounter).add(p1Won);
                else
                    allTheCombinationOfEveryPossibleEvent.get(eventCounter).add(p2Won);

            }
            generalEventCounter++;

        }
        for (ArrayList<complexBetIndvEntry> combinationOfEvents : allTheCombinationOfEveryPossibleEvent) {
            double finalMomio = 1;
            double finalPriority = 0;
            String combination_code = "";
            ArrayList<complexBetIndvEntry> newComplexBetIndvEntreArray = new ArrayList<complexBetIndvEntry>();
            for (complexBetIndvEntry individualEvent : combinationOfEvents) {
                finalMomio *= individualEvent.getWinnerPlayerMomio();
                finalPriority += individualEvent.getPriority();
                combination_code += "☺" + individualEvent.getWinnerPlayer();
                newComplexBetIndvEntreArray.add(individualEvent);
            }

            allTheCombinationOfEveryPossibleEventWithMomio.add(
                    new finalSingleMultipleComplexBet(finalPriority, finalMomio, ownerHouse.getMomioType(), ownerHouse,
                            combination_code, newComplexBetIndvEntreArray));
        }
        Collections.sort(allTheCombinationOfEveryPossibleEventWithMomio);
        return allTheCombinationOfEveryPossibleEventWithMomio;
    }

    public ArrayList<ArrayList<complexBetIndvEntry>> getAllTheCombinationOfEveryPossibleEvent() {
        return this.allTheCombinationOfEveryPossibleEvent;
    }

    public void setAllTheCombinationOfEveryPossibleEvent(
            ArrayList<ArrayList<complexBetIndvEntry>> allTheCombinationOfEveryPossibleEvent) {
        this.allTheCombinationOfEveryPossibleEvent = allTheCombinationOfEveryPossibleEvent;
    }

    public betHouse getOwnerHouse() {
        return this.ownerHouse;
    }

    public void setOwnerHouse(betHouse ownerHouse) {
        this.ownerHouse = ownerHouse;
    }

    public ArrayList<complexBetIndvEntry> getIndividualTotalEvents() {
        return this.IndividualTotalEvents;
    }

    public void setIndividualTotalEvents(ArrayList<complexBetIndvEntry> IndividualTotalEvents) {
        this.IndividualTotalEvents = IndividualTotalEvents;
    }
}
