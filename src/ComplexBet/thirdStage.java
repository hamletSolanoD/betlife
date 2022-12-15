package ComplexBet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.*;

import Interfaces.*;
import Structs.*;
import CustomComponents.*;

public class thirdStage extends JFrame implements ActionListener {

    private complexBet NEW_COMPLEX_BET;

    TreeMap<finalSingleMultipleComplexBet, Double> finalBestEvents;

    public thirdStage(complexBet NEW_COMPLEX_BET) {
        setBounds(0, 0, projectConstants.screenWidth, projectConstants.screenHeight);
        setLayout(new BorderLayout());

        finalBestEvents = NEW_COMPLEX_BET.generate_best_option_and_investment();
        this.NEW_COMPLEX_BET = NEW_COMPLEX_BET;

        JPanel rows = new JPanel(new GridLayout(0, 1));

        rows.add(create_headers());

        // for (finalSingleMultipleComplexBet finalSingleMultipleComplexBet :
        // finalBestEvents) {

        // }

        add(rows, BorderLayout.CENTER);
        setVisible(true);

    }

    private JPanel createDataRow(finalSingleMultipleComplexBet finalSingleMultipleComplexBet) {
        JPanel row = new JPanel(new GridLayout(1, 0));
        JLabel house = new JLabel(finalSingleMultipleComplexBet.getBetHouse().getBetHouseName());
        row.add(house);

        ArrayList<complexBetIndvEntry> events = finalSingleMultipleComplexBet.getAllTheSelectedEvents();
        for (complexBetIndvEntry individualEvent : events) {
            JLabel eventsHeaders = new JLabel("<html>" + individualEvent.getWinnerPlayer() + "<br></br>"
                    + individualEvent.getWinnerPlayerMomio());
            row.add(eventsHeaders);
        }

        JLabel probability = new JLabel(finalSingleMultipleComplexBet.getMomioType().toString() + ": "
                + finalSingleMultipleComplexBet.getMomio());
        row.add(probability);

        JLabel investment = new JLabel("Inversion");
        row.add(investment);

        JLabel accumulatedExpense = new JLabel("Gasto Acumulado");
        row.add(accumulatedExpense);

        JLabel coveredCases = new JLabel("Casos Cubiertos");
        row.add(coveredCases);

        JLabel result = new JLabel("Resultado");
        row.add(result);

        JLabel profit = new JLabel("Ganancia");
        row.add(profit);

        JLabel realProfit = new JLabel("Ganancia Real");
        row.add(realProfit);

        return row;
    }

    private JPanel create_headers() {
        JPanel headers = new JPanel(new GridLayout(1, 0));

        JLabel houses = new JLabel("Casas");
        headers.add(houses);
        // for (complexBetIndvEntry events :
        // finalBestEvents.get(0).getAllTheSelectedEvents()) {
        // JLabel eventsHeaders = new JLabel(events.getBetEventName());
        // headers.add(eventsHeaders);
        // }

        JLabel probability = new JLabel("Probabilidad");
        headers.add(probability);

        JLabel investment = new JLabel("Inversion");
        headers.add(investment);

        JLabel accumulatedExpense = new JLabel("Gasto Acumulado");
        headers.add(accumulatedExpense);

        JLabel coveredCases = new JLabel("Casos Cubiertos");
        headers.add(coveredCases);

        JLabel result = new JLabel("Resultado");
        headers.add(result);

        JLabel profit = new JLabel("Ganancia");
        headers.add(profit);

        JLabel realProfit = new JLabel("Ganancia Real");
        headers.add(realProfit);

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
