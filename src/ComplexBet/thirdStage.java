package ComplexBet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.*;

import Interfaces.*;
import Structs.*;
import CustomComponents.*;

public class thirdStage extends JFrame implements ActionListener {

    private complexBet NEW_COMPLEX_BET;
    private JFrame context;
    private Double minAvailableAmount;

    public thirdStage(complexBet NEW_COMPLEX_BET) {

        JScrollPane panel = new JScrollPane();

        TreeMap<String, TreeMap<String, Double>> mapedByEventHouseAndProb = NEW_COMPLEX_BET
                .generateBestOptionsByHouses();

        this.NEW_COMPLEX_BET = NEW_COMPLEX_BET;

        JPanel rows = new JPanel(new GridLayout(0, 1));
        JPanel Headers = new JPanel(new GridLayout(1, 0));
        boolean headersBool = false;
        Double acumulatedInversionCounter = 0.0;
        float counterOfCases = 1;
        for (Entry<String, TreeMap<String, Double>> betCase : mapedByEventHouseAndProb.entrySet()) {// key is the event
                                                                                                    // house is the key
                                                                                                    // of the value and
                                                                                                    // prob is the value
                                                                                                    // of the value
            JPanel columns = new JPanel(new GridLayout(1, 0));

            for (Entry<String, Double> HouseAndProb : betCase.getValue().entrySet()) {
                // house and prob of every event
                JPanel Tittles = new JPanel(new BorderLayout());
                Tittles.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                JLabel house = new JLabel(HouseAndProb.getKey());
                house.setHorizontalAlignment(JLabel.CENTER);
                Tittles.add(house, BorderLayout.CENTER);
                columns.add(Tittles);// house name

                String[] casesByEvent = betCase.getKey().split("\\☺");
                if (!headersBool) {
                    headersBool = true;
                    JLabel houseHeader = new JLabel("Casas");
                    houseHeader.setHorizontalAlignment(JLabel.CENTER);
                    houseHeader.setHorizontalAlignment(JLabel.CENTER);
                    houseHeader.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(houseHeader);
                    for (int e = 1; e <= casesByEvent.length; e++) {
                        JLabel event = new JLabel("Evento #" + e);
                        event.setHorizontalAlignment(JLabel.CENTER);
                        event.setHorizontalAlignment(JLabel.CENTER);
                        event.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                        Headers.add(event);
                    }
                    JLabel eventProb = new JLabel("Probabilidad");
                    eventProb.setHorizontalAlignment(JLabel.CENTER);
                    eventProb.setHorizontalAlignment(JLabel.CENTER);
                    eventProb.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(eventProb);

                    JLabel Inversion = new JLabel("Inversion");
                    Inversion.setHorizontalAlignment(JLabel.CENTER);
                    Inversion.setHorizontalAlignment(JLabel.CENTER);
                    Inversion.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(Inversion);

                    JLabel acumulatedInversion = new JLabel("Gasto Acumulado");
                    acumulatedInversion.setHorizontalAlignment(JLabel.CENTER);
                    acumulatedInversion.setHorizontalAlignment(JLabel.CENTER);
                    acumulatedInversion.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(acumulatedInversion);

                    JLabel probabilityCovered = new JLabel("Casos Cubiertos");
                    probabilityCovered.setHorizontalAlignment(JLabel.CENTER);
                    probabilityCovered.setHorizontalAlignment(JLabel.CENTER);
                    probabilityCovered.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(probabilityCovered);
                    rows.add(Headers);

                    JLabel Resultado = new JLabel("Resultado");
                    Resultado.setHorizontalAlignment(JLabel.CENTER);
                    Resultado.setHorizontalAlignment(JLabel.CENTER);
                    Resultado.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(Resultado);

                    JLabel Ganancia = new JLabel("Ganancia");
                    Ganancia.setHorizontalAlignment(JLabel.CENTER);
                    Ganancia.setHorizontalAlignment(JLabel.CENTER);
                    Ganancia.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(Ganancia);

                    JLabel realAcumulatedGanancia = new JLabel("Ganancia Real");
                    realAcumulatedGanancia.setHorizontalAlignment(JLabel.CENTER);
                    realAcumulatedGanancia.setHorizontalAlignment(JLabel.CENTER);
                    realAcumulatedGanancia.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    Headers.add(realAcumulatedGanancia);

                }

                for (String winner : casesByEvent) {

                    JButton winnerlabAndProb = new JButton();
                    winnerlabAndProb.setText("<html>" + winner + "<br />"
                            + multiple.getOriginalProbOfPlayerAndHouse(HouseAndProb.getKey(), winner) + "</html>");
                    winnerlabAndProb.setActionCommand(HouseAndProb.getKey() + "☺" + winner);
                    winnerlabAndProb.addActionListener(this);

                    winnerlabAndProb.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                    winnerlabAndProb.setHorizontalAlignment(JLabel.CENTER);
                    columns.add(winnerlabAndProb);
                } // winners

                JLabel winnerProb = new JLabel("Decimal: \n" + HouseAndProb.getValue());
                winnerProb.setHorizontalAlignment(JLabel.CENTER);
                winnerProb.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                Double inversionGainedResultRealProfit[] = multiple.neededInversionForEveryEvent(minAvailableAmount,
                        betCase.getKey());

                JLabel inversionAmount = new JLabel("" + inversionGainedResultRealProfit[0]);
                inversionAmount.setHorizontalAlignment(JLabel.CENTER);
                inversionAmount.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                acumulatedInversionCounter += inversionGainedResultRealProfit[0];

                JLabel finalGainedResult = new JLabel("" + inversionGainedResultRealProfit[1]);
                finalGainedResult.setHorizontalAlignment(JLabel.CENTER);
                finalGainedResult.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                JLabel realProfit = new JLabel("" + inversionGainedResultRealProfit[2]);
                realProfit.setHorizontalAlignment(JLabel.CENTER);
                realProfit.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                JLabel acumulatedInversion = new JLabel("" + acumulatedInversionCounter);
                acumulatedInversion.setHorizontalAlignment(JLabel.CENTER);
                acumulatedInversion.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                JLabel probabilityCovered = new JLabel((counterOfCases / mapedByEventHouseAndProb.size()) * 100 + "%");
                probabilityCovered.setHorizontalAlignment(JLabel.CENTER);
                probabilityCovered.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));
                System.out.println((counterOfCases / mapedByEventHouseAndProb.size()) * 100);
                counterOfCases++;

                JLabel realProfitInCascade = new JLabel(minAvailableAmount - acumulatedInversionCounter + "");
                realProfitInCascade.setHorizontalAlignment(JLabel.CENTER);
                realProfitInCascade.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                columns.add(winnerProb);
                columns.add(inversionAmount);
                columns.add(acumulatedInversion);
                columns.add(probabilityCovered);
                columns.add(finalGainedResult);
                columns.add(realProfit);
                columns.add(realProfitInCascade);

            }
            rows.add(columns);
        }
        panel.setViewportView(rows);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

    }

    String nameOfPlayer;
    String HouseName;
    jDialogToModifyProbsOfSpecificPlayer jdialog = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("☺")) {
            String toDeserealice = e.getActionCommand();
            String values[] = toDeserealice.split("☺");
            HouseName = values[0];
            nameOfPlayer = values[1];

            // JDialgo to modify playerProbs
            jdialog = new jDialogToModifyProbsOfSpecificPlayer(HouseName, nameOfPlayer, this, this);

        } else {
            switch (e.getActionCommand()) {
                case "Aceptarmod":
                    // double newProb = jdialog.getNewProbValue();
                    //// MomioType momio = jdialog.getTypeOfMomio();
                    //// if (newProb != 0 && momio != null) {
                    //// multiBet.modifySimpleBetRespectHouses(HouseName, nameOfPlayer, newProb,
                    // momio);
                    // dispose();
                    // new thirdStage(multiBet, context, minAvailableAmount);
                    // }

                    break;

            }

        }
    }
}
