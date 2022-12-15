package Structs;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import Interfaces.projectConstants.MomioType;

public class complexBet {

    private ArrayList<indvBet> TotalEvents;
    private TreeMap<String, ArrayList<complexBetIndvEntry>> EventsGroupByEventName = new TreeMap<String, ArrayList<complexBetIndvEntry>>();
    private TreeMap<String, ArrayList<finalSingleMultipleComplexBet>> HousesAndItsEvents = new TreeMap<String, ArrayList<finalSingleMultipleComplexBet>>();

    public complexBet(ArrayList<indvBet> TotalEvents) {
        this.TotalEvents = TotalEvents;
    }

    private void fill_multipeIndvBetMap() {
        for (indvBet event : TotalEvents) {
            if (!EventsGroupByEventName.containsKey(event.getBetEventName())) {
                ArrayList<complexBetIndvEntry> groupedEvents = new ArrayList<complexBetIndvEntry>();
                groupedEvents.add(new complexBetIndvEntry(event));
                EventsGroupByEventName.put(event.getBetEventName(), groupedEvents);
            } else {
                ArrayList<complexBetIndvEntry> groupedEvents = EventsGroupByEventName.get(event.getBetEventName());
                groupedEvents.add(new complexBetIndvEntry(event));

            }
        }
    }

    private void cast_multiple_events_by_BetHouse() {// groups by house hash and generates all the bet possible events
                                                     // by house
        TreeMap<String, ArrayList<complexBetIndvEntry>> EventsGroupByBetHouse = new TreeMap<String, ArrayList<complexBetIndvEntry>>();
        for (ArrayList<complexBetIndvEntry> e : EventsGroupByEventName.values()) {
            for (complexBetIndvEntry event : e) {

                String hashBetHouse = event.getBetHouse().getBetHouseName() + event.getBetHouse().getbetHouseLink();
                if (!EventsGroupByBetHouse.containsKey(hashBetHouse)) {
                    ArrayList<complexBetIndvEntry> newGroupedByBetHouse = new ArrayList<complexBetIndvEntry>();
                    EventsGroupByBetHouse.put(hashBetHouse, newGroupedByBetHouse);
                }
                ArrayList<complexBetIndvEntry> GroupedByBetHouse = EventsGroupByBetHouse.get(hashBetHouse);
                GroupedByBetHouse.add(event);

            }
        }

        for (Entry<String, ArrayList<complexBetIndvEntry>> entry : EventsGroupByBetHouse.entrySet()) {
            multipleBetEntries newMultiByHouse = new multipleBetEntries();
            newMultiByHouse.getIndividualTotalEvents().addAll(entry.getValue());
            newMultiByHouse.setOwnerHouse(entry.getValue().get(0).getBetHouse());

            ArrayList<finalSingleMultipleComplexBet> houseEvents = newMultiByHouse
                    .generate_every_combination_by_BetHouse();

            HousesAndItsEvents.put(entry.getValue().get(0).getBetHouse().getBetHouseName()
                    + entry.getValue().get(0).getBetHouse().getBetHouseLink(), houseEvents);
        }
    }

    private ArrayList<finalSingleMultipleComplexBet> generate_best_option_by_global_event() {
        fill_multipeIndvBetMap();
        cast_multiple_events_by_BetHouse();

        TreeMap<String, ArrayList<finalSingleMultipleComplexBet>> mappedByEvent = new TreeMap<String, ArrayList<finalSingleMultipleComplexBet>>();

        for (Entry<String, ArrayList<finalSingleMultipleComplexBet>> entry : HousesAndItsEvents.entrySet()) {

            for (finalSingleMultipleComplexBet finalSingleMultipleComplexBet : entry.getValue()) {

                if (!mappedByEvent.containsKey(finalSingleMultipleComplexBet.getCombination_code())) {
                    ArrayList<finalSingleMultipleComplexBet> newEvents = new ArrayList<finalSingleMultipleComplexBet>();
                    mappedByEvent.put(finalSingleMultipleComplexBet.getCombination_code(), newEvents);
                }
                ArrayList<finalSingleMultipleComplexBet> events = mappedByEvent
                        .get(finalSingleMultipleComplexBet.getCombination_code());
                events.add(finalSingleMultipleComplexBet);

            }

        }

        ArrayList<finalSingleMultipleComplexBet> theBestPossibleArrayWithDifferentHouses = new ArrayList<finalSingleMultipleComplexBet>();
        for (Entry<String, ArrayList<finalSingleMultipleComplexBet>> entry : mappedByEvent.entrySet()) {
            finalSingleMultipleComplexBet theBestOne = null;
            for (finalSingleMultipleComplexBet finalSingleMultipleComplexBet : entry.getValue()) {
                if (theBestOne == null)
                    theBestOne = finalSingleMultipleComplexBet;
                else if (MomioType.compare_momios(finalSingleMultipleComplexBet.getMomio(),
                        finalSingleMultipleComplexBet.getMomioType(), theBestOne.getMomio(),
                        theBestOne.getMomioType()) == 1) {
                    theBestOne = finalSingleMultipleComplexBet;
                }

            }
            theBestPossibleArrayWithDifferentHouses.add(theBestOne);

        }

        return theBestPossibleArrayWithDifferentHouses;
    }

    public ArrayList<finalSingleMultipleComplexBet> generate_best_option_and_investment() {

        ArrayList<finalSingleMultipleComplexBet> best_option_and_houses = generate_best_option_by_global_event();

        TreeMap<String, ArrayList<finalSingleMultipleComplexBet>> multipleComplexBetsGroupByHouse = new TreeMap<String, ArrayList<finalSingleMultipleComplexBet>>();

        for (finalSingleMultipleComplexBet finalSingleMultipleComplexBet : best_option_and_houses) {
            if (!multipleComplexBetsGroupByHouse
                    .containsKey(finalSingleMultipleComplexBet.getBetHouse().getBetHouseName()
                            + (finalSingleMultipleComplexBet.getBetHouse().getBetHouseLink()))) {
                ArrayList<finalSingleMultipleComplexBet> newGroupedEvents = new ArrayList<finalSingleMultipleComplexBet>();
                multipleComplexBetsGroupByHouse.put(finalSingleMultipleComplexBet.getBetHouse().getBetHouseName()
                        + (finalSingleMultipleComplexBet.getBetHouse().getBetHouseLink()), newGroupedEvents);
            }
            ArrayList<finalSingleMultipleComplexBet> groupedEvents = multipleComplexBetsGroupByHouse
                    .get(finalSingleMultipleComplexBet.getBetHouse().getBetHouseName()
                            + (finalSingleMultipleComplexBet.getBetHouse().getBetHouseLink()));
            groupedEvents.add(finalSingleMultipleComplexBet);

        }

        // alredygroup by Key:houseName+HouseLine Value: ArrayList of the best selected
        // complex bets in that house
        double minprofit = Double.MAX_VALUE;
        ArrayList<finalSingleMultipleComplexBet> finalBestOptionWithProfitAndInversion = new ArrayList<finalSingleMultipleComplexBet>();

        for (Entry<String, ArrayList<finalSingleMultipleComplexBet>> entryByHouse : multipleComplexBetsGroupByHouse
                .entrySet()) {
            double totalSumMomios = 0;
            for (finalSingleMultipleComplexBet event : entryByHouse.getValue()) {
                totalSumMomios += 1 / MomioType.momio_to_decimal(event.getMomio(), event.getMomioType());
            }
            double houseCurrentProfit = (entryByHouse.getValue().get(0).getBetHouse().getTotalMoneyAmount() * 0.60)
                    / totalSumMomios;
            minprofit = minprofit > houseCurrentProfit ? houseCurrentProfit : minprofit;
        }
        for (Entry<String, ArrayList<finalSingleMultipleComplexBet>> entryByHouse : multipleComplexBetsGroupByHouse
                .entrySet()) {
            for (finalSingleMultipleComplexBet event : entryByHouse.getValue()) {
                event.setInvestment(minprofit / MomioType.momio_to_decimal(event.getMomio(), event.getMomioType()));
                finalBestOptionWithProfitAndInversion.add(event);
            }

        }

        return finalBestOptionWithProfitAndInversion;

    }
}