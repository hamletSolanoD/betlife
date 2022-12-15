package ComplexBet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.*;

import Interfaces.*;
import Interfaces.projectConstants.MomioType;
import Structs.*;

public class secondStage extends JFrame implements ActionListener {

    private complexBet NEW_COMPLEX_BET;

    ArrayList<betHouse> betHouses;
    ArrayList<indvBet> indvEventsIncomplete;

    ArrayList<GUI_indvBetObject> GUI_indvBetFields = new ArrayList<GUI_indvBetObject>();

    class GUI_indvBetObject {
        String betHouse;
        String EventName;
        String Player1Name;
        String Player2Name;
        String LinkOfTheBetHouse;
        double BetHouseMoneyAmount;
        MomioType momioType;
        JSpinner player1TextField[] = new JSpinner[1];
        JSpinner player2TextField[] = new JSpinner[1];
        JComboBox TypeOfMomioJCB[] = new JComboBox[1];

        public GUI_indvBetObject(String betHouse, String EventName, String Player1Name, String Player2Name,
                String LinkOfTheBetHouse, JSpinner player1TextField2,
                JSpinner player2TextField2, double BetHouseMoneyAmount, MomioType momioType, JComboBox TypeOfMomioJCB) {
            this.betHouse = betHouse;
            this.EventName = EventName;
            this.Player1Name = Player1Name;
            this.Player2Name = Player2Name;
            this.LinkOfTheBetHouse = LinkOfTheBetHouse;
            this.player1TextField[0] = player1TextField2;
            this.player2TextField[0] = player2TextField2;
            this.BetHouseMoneyAmount = BetHouseMoneyAmount;
            this.momioType = momioType;
            this.TypeOfMomioJCB[0] = TypeOfMomioJCB;
        }

    }

    private JPanel create_Momio_Event_Field(betHouse betHouse, indvBet indvBet) {
        JPanel LocalJPanel = new JPanel(new GridBagLayout());
        GridBagConstraints localGBC = new GridBagConstraints();
        localGBC.insets = new Insets(5, 5, 5, 5);
        localGBC.weightx = 1;
        localGBC.weighty = 1;

        localGBC.gridx = 0;
        localGBC.gridy = 0;
        localGBC.gridwidth = 2;

        localGBC.fill = GridBagConstraints.HORIZONTAL;
        JLabel houseTittle = new JLabel(betHouse.getBetHouseName());
        houseTittle.setHorizontalAlignment(JLabel.CENTER);
        LocalJPanel.add(houseTittle, localGBC);

        localGBC.fill = GridBagConstraints.NONE;
        localGBC.gridwidth = 1;

        localGBC.gridx = 0;
        localGBC.gridy = 2;
        JLabel Player1JL = new JLabel(indvBet.getPlayer1Name());
        LocalJPanel.add(Player1JL, localGBC);

        localGBC.gridx = 1;
        localGBC.gridy = 2;
        JSpinner player1TextField = new JSpinner(new SpinnerNumberModel(0.00, -1000, 1000, 1));
        player1TextField.setPreferredSize(new Dimension(300, 30));
        LocalJPanel.add(player1TextField, localGBC);

        localGBC.gridx = 0;
        localGBC.gridy = 3;
        JLabel player2JL = new JLabel(indvBet.getPlayer2Name());
        LocalJPanel.add(player2JL, localGBC);

        localGBC.gridx = 1;
        localGBC.gridy = 3;
        JSpinner player2TextField = new JSpinner(new SpinnerNumberModel(0.00, -1000, 1000, 1));
        player2TextField.setPreferredSize(new Dimension(300, 30));
        LocalJPanel.add(player2TextField, localGBC);

        localGBC.gridx = 0;
        localGBC.gridy = 1;
        JLabel TypeOfMomioJL = new JLabel("Tipo de momio");
        LocalJPanel.add(TypeOfMomioJL, localGBC);

        localGBC.gridx = 1;
        localGBC.gridy = 1;
        JComboBox TypeOfMomioJCB = new JComboBox(projectConstants.TypesOfMomios);
        TypeOfMomioJCB.setSelectedItem(betHouse.getMomioType().toString());
        TypeOfMomioJCB.setPreferredSize(new Dimension(300, 30));
        LocalJPanel.add(TypeOfMomioJCB, localGBC);

        localGBC.fill = GridBagConstraints.HORIZONTAL;
        localGBC.gridx = 0;
        localGBC.gridy = 4;
        localGBC.gridwidth = 2;
        JLabel linkOfBerHouse = new JLabel(betHouse.getBetHouseLink());
        linkOfBerHouse.setHorizontalAlignment(JLabel.CENTER);
        LocalJPanel.add(linkOfBerHouse, localGBC);

        GUI_indvBetObject eventByHouse = new GUI_indvBetObject(betHouse.getBetHouseName(), indvBet.getBetEventName(),
                indvBet.getPlayer1Name(), indvBet.getPlayer2Name(),
                betHouse.getBetHouseLink(), player1TextField, player2TextField, betHouse.getTotalMoneyAmount(),
                betHouse.getMomioType(), TypeOfMomioJCB);
        GUI_indvBetFields.add(eventByHouse);

        return LocalJPanel;

    }

    public secondStage(ArrayList<betHouse> betHouses, ArrayList<indvBet> indvEvents) {

        setBounds(0, 0, projectConstants.screenWidth / 3, (projectConstants.screenHeight / 2));
        setLayout(new BorderLayout());

        this.betHouses = betHouses;
        this.indvEventsIncomplete = indvEvents;

        JPanel ScrollablePanel = new JPanel(new BorderLayout());
        JScrollPane scrollPanel = new JScrollPane();

        JLabel Tittle = new JLabel("Momios por eventos");
        Tittle.setFont(projectConstants.titleFont);
        Tittle.setHorizontalAlignment(JLabel.CENTER);
        Tittle.setPreferredSize(new Dimension(Tittle.getPreferredSize().width, 80));
        ScrollablePanel.add(Tittle, BorderLayout.NORTH);

        JPanel momiosEventLayout = new JPanel(new GridBagLayout());
        GridBagConstraints momiosEventsGBC = new GridBagConstraints();
        momiosEventsGBC.fill = GridBagConstraints.HORIZONTAL;
        momiosEventsGBC.gridx = 0;
        momiosEventsGBC.gridy = GridBagConstraints.RELATIVE;
        momiosEventsGBC.insets = new Insets(10, 10, 10, 10);
        momiosEventsGBC.weightx = 1;
        momiosEventsGBC.weighty = 1;

        for (betHouse betHouse : betHouses) {

            for (indvBet event : indvEvents) {

                JPanel newBetFields = create_Momio_Event_Field(betHouse, event);

                newBetFields.setBorder(BorderFactory.createLineBorder(projectConstants.detailsDark));

                momiosEventLayout.add(newBetFields, momiosEventsGBC);

            }
        }

        ScrollablePanel.add(momiosEventLayout, BorderLayout.CENTER);

        scrollPanel.setViewportView(ScrollablePanel);

        add(scrollPanel, BorderLayout.CENTER);

        {// next Step
            JPanel nextButtons = new JPanel(new BorderLayout());
            JPanel buttons = new JPanel(new GridLayout(1, 0));

            JButton previous = new JButton("Anterior");
            previous.addActionListener(this);
            previous.setActionCommand("Anterior");

            JButton Next = new JButton("Siguiente");
            Next.addActionListener(this);
            Next.setActionCommand("Siguiente");

            buttons.add(previous);
            buttons.add(Box.createHorizontalStrut(10));
            buttons.add(Next);

            nextButtons.add(buttons, BorderLayout.EAST);

            add(nextButtons, BorderLayout.SOUTH);

        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch (e.getActionCommand()) {
            case "Anterior":
                dispose();
                break;
            case "Siguiente":
                ArrayList<indvBet> completedIndvBets = new ArrayList<indvBet>();
                TreeMap<String, betHouse> mappedHouseByHash = new TreeMap<String, betHouse>();

                for (GUI_indvBetObject GUIindv : GUI_indvBetFields) {
                    for (indvBet indv : indvEventsIncomplete) {
                        if (GUIindv.EventName.equals(indv.getBetEventName())) {
                            String hashHouse = GUIindv.EventName + GUIindv.LinkOfTheBetHouse;

                            if (!mappedHouseByHash.containsKey(hashHouse))
                                mappedHouseByHash.put(hashHouse, new betHouse(GUIindv.betHouse,
                                        GUIindv.LinkOfTheBetHouse, GUIindv.BetHouseMoneyAmount,
                                        projectConstants.MomioType.getTypeByString(
                                                ((String) GUIindv.TypeOfMomioJCB[0].getSelectedItem()))));

                            betHouse betHouse = mappedHouseByHash.get(hashHouse);
                            indvBet newinIndvBet = new indvBet(indv.getBetEventName(), betHouse,
                                    indv.getFavoritePlayer(), indv.getPlayer1Name(), indv.getPlayer2Name(),
                                    (double) GUIindv.player1TextField[0].getValue(),
                                    (double) GUIindv.player2TextField[0].getValue());

                            completedIndvBets.add(newinIndvBet);
                        }
                    }
                }

                NEW_COMPLEX_BET = new complexBet(completedIndvBets);
                new thirdStage(NEW_COMPLEX_BET);

                break;

        }
    }

}
