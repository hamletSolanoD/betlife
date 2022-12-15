package ComplexBet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.*;

import Interfaces.*;
import Interfaces.projectConstants.MomioType;
import Structs.*;

public class thirdStage extends JFrame implements ActionListener {

    private double acumulatedInvestment = 0;
    private double acumulatedPercentage = 0;

    ArrayList<finalSingleMultipleComplexBet> finalBestEvents;

    private static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public thirdStage(complexBet NEW_COMPLEX_BET) {
        setBounds(0, 0, projectConstants.screenWidth, projectConstants.screenHeight);
        setLayout(new BorderLayout());

        finalBestEvents = NEW_COMPLEX_BET.generate_best_option_and_investment();

        JPanel rows = new JPanel(new GridLayout(0, 1));

        rows.add(create_headers());

        for (finalSingleMultipleComplexBet finalSingleMultipleComplexBet : finalBestEvents) {
            rows.add(createDataRow(finalSingleMultipleComplexBet));

        }

        add(rows, BorderLayout.CENTER);
        setVisible(true);

    }

    private JPanel createDataRow(finalSingleMultipleComplexBet finalSingleMultipleComplexBet) {
        JPanel row = new JPanel(new GridLayout(1, 0));
        personalizedThirdCell house = new personalizedThirdCell(
                finalSingleMultipleComplexBet.getBetHouse().getBetHouseName());
        row.add(house);

        ArrayList<complexBetIndvEntry> events = finalSingleMultipleComplexBet.getAllTheSelectedEvents();
        for (complexBetIndvEntry individualEvent : events) {
            personalizedThirdCell eventsHeaders = new personalizedThirdCell(
                    "<html>" + individualEvent.getWinnerPlayer() + "<br></br>"
                            + individualEvent.getWinnerPlayerMomio());
            row.add(eventsHeaders);
        }

        personalizedThirdCell probability = new personalizedThirdCell(
                finalSingleMultipleComplexBet.getMomioType().toString() + ": "
                        + round(finalSingleMultipleComplexBet.getMomio(), 3));
        row.add(probability);

        personalizedThirdCell investment = new personalizedThirdCell(
                round(finalSingleMultipleComplexBet.getInvestment(), 3) + "$");
        row.add(investment);

        acumulatedInvestment += finalSingleMultipleComplexBet.getInvestment();
        personalizedThirdCell accumulatedExpense = new personalizedThirdCell(round(acumulatedInvestment, 3) + "$");
        row.add(accumulatedExpense);

        acumulatedPercentage += (100.0 / (double) finalBestEvents.size());
        personalizedThirdCell coveredCases = new personalizedThirdCell(round(acumulatedPercentage, 3) + "%");
        row.add(coveredCases);

        personalizedThirdCell profit = new personalizedThirdCell(round(
                (finalSingleMultipleComplexBet.getInvestment() * MomioType.momio_to_decimal(
                        finalSingleMultipleComplexBet.getMomio(), finalSingleMultipleComplexBet.getMomioType())),
                3) + "$");
        row.add(profit);

        personalizedThirdCell realProfit = new personalizedThirdCell(round(
                ((finalSingleMultipleComplexBet.getInvestment() * MomioType.momio_to_decimal(
                        finalSingleMultipleComplexBet.getMomio(), finalSingleMultipleComplexBet.getMomioType()))
                        - (finalSingleMultipleComplexBet
                                .getInvestment())),
                3) + "$");
        row.add(realProfit);

        personalizedThirdCell acumulatedRealProfit = new personalizedThirdCell(round(
                ((finalSingleMultipleComplexBet.getInvestment() * MomioType.momio_to_decimal(
                        finalSingleMultipleComplexBet.getMomio(), finalSingleMultipleComplexBet.getMomioType()))
                        - acumulatedInvestment),
                3) + "$");
        row.add(acumulatedRealProfit);

        return row;
    }

    private JPanel create_headers() {
        JPanel headers = new JPanel(new GridLayout(1, 0));

        personalizedThirdCell houses = new personalizedThirdCell("Casas");
        headers.add(houses);
        for (complexBetIndvEntry events : finalBestEvents.get(0).getAllTheSelectedEvents()) {
            personalizedThirdCell eventsHeaders = new personalizedThirdCell(events.getBetEventName());
            headers.add(eventsHeaders);
        }

        personalizedThirdCell probability = new personalizedThirdCell("Probabilidad");
        headers.add(probability);

        personalizedThirdCell investment = new personalizedThirdCell("Inversion");
        headers.add(investment);

        personalizedThirdCell accumulatedExpense = new personalizedThirdCell("Gasto Acumulado");
        headers.add(accumulatedExpense);

        personalizedThirdCell coveredCases = new personalizedThirdCell("Casos Cubiertos");
        headers.add(coveredCases);

        personalizedThirdCell profit = new personalizedThirdCell("Ganancia");
        headers.add(profit);

        personalizedThirdCell realProfit = new personalizedThirdCell("Ganancia Real Individual");
        headers.add(realProfit);

        personalizedThirdCell acumulatedRealProfit = new personalizedThirdCell("Ganancia Real Acumulada");
        headers.add(acumulatedRealProfit);

        return headers;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("☺")) {

        } else {
            switch (e.getActionCommand()) {
                case "Aceptarmod":

                    break;

            }

        }
    }
}

class personalizedThirdCell extends JLabel {
    private void set_personalized_format() {
        this.setBorder(BorderFactory.createLineBorder(projectConstants.details));

    }

    public personalizedThirdCell(String title, int truncate) {
        super(title.substring(0, truncate));
        set_personalized_format();
    }

    public personalizedThirdCell(String title) {
        super(title);
        set_personalized_format();

    }

}