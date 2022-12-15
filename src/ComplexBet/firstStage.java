package ComplexBet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Interfaces.*;
import Interfaces.projectConstants.MomioType;
import Structs.*;

public class firstStage extends JFrame implements ChangeListener, ActionListener {

    int currentHouseFields = 0;
    int currentEventFields = 0;

    JTextField TitleEntry;
    JTextArea DescriptionEntry;
    JSpinner MoneyAmount;
    JComboBox TypeOfCurrency;
    JSpinner NumberOfBets;
    JSpinner NumberOfHouses;
    String currency[] = { "MXN", "DLL" };

    private ArrayList<JTextField> BetHouseTitles = new ArrayList<JTextField>();
    private ArrayList<JTextField> BetHouseLinks = new ArrayList<JTextField>();
    private ArrayList<JSpinner> MoneyBalanceInEveryHouse = new ArrayList<JSpinner>();
    private ArrayList<JComboBox> TypeOfMomioInEveryHouse = new ArrayList<JComboBox>();

    private ArrayList<String> EventsNames = new ArrayList<String>();
    private ArrayList<JTextField> Players1 = new ArrayList<JTextField>();
    private ArrayList<JTextField> Players2 = new ArrayList<JTextField>();
    private ArrayList<ButtonGroup> favoritePlayers = new ArrayList<ButtonGroup>();

    ArrayList<String> HousesNames = new ArrayList<String>();

    JPanel HousesNamesInputLayout = new JPanel(new GridBagLayout());
    JPanel betEventsInputs = new JPanel(new GridBagLayout());

    public firstStage(JFrame context) {
        setBounds(0, 0, projectConstants.screenWidth / 3, (projectConstants.screenHeight / 2));
        setLayout(new BorderLayout());

        JScrollPane scrollViewPanel = new JScrollPane();
        JPanel scrollView = new JPanel(new BorderLayout());

        JPanel formEntryContent = new JPanel(new GridBagLayout());
        GridBagConstraints grdibagConstrains = new GridBagConstraints();

        grdibagConstrains.fill = GridBagConstraints.HORIZONTAL;
        grdibagConstrains.anchor = GridBagConstraints.FIRST_LINE_START;
        grdibagConstrains.gridx = 0;
        grdibagConstrains.gridheight = 2;
        grdibagConstrains.weightx = 1;

        grdibagConstrains.insets = new Insets(10, 10, 10, 10);
        grdibagConstrains.gridy = GridBagConstraints.RELATIVE;

        JLabel Tittle = new JLabel("Nueva entrada compleja");
        Tittle.setFont(projectConstants.titleFont);
        Tittle.setHorizontalAlignment(JTextField.CENTER);
        Tittle.setPreferredSize(new Dimension(Tittle.getPreferredSize().width, 80));
        formEntryContent.add(Tittle, grdibagConstrains);

        JPanel titleJPanel = new JPanel(new BorderLayout());
        titleJPanel.add(new JLabel("Titulo"), BorderLayout.NORTH);
        TitleEntry = new JTextField("Nueva Entrada");
        titleJPanel.add(TitleEntry, BorderLayout.CENTER);
        titleJPanel.setPreferredSize(new Dimension(titleJPanel.getPreferredSize().width, 50));
        grdibagConstrains.gridheight = 1;
        formEntryContent.add(titleJPanel, grdibagConstrains);

        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.add(new JLabel("Description"), BorderLayout.NORTH);
        DescriptionEntry = new JTextArea("Nueva Entrada");
        descriptionPanel.add(DescriptionEntry, BorderLayout.CENTER);
        descriptionPanel.setPreferredSize(new Dimension(titleJPanel.getPreferredSize().width, 100));
        grdibagConstrains.gridheight = 2;
        formEntryContent.add(descriptionPanel, grdibagConstrains);

        JPanel InversionPanel = new JPanel(new BorderLayout());
        JPanel inversionPanelForm = new JPanel(new GridBagLayout());
        GridBagConstraints inversionPanelGBC = new GridBagConstraints();
        inversionPanelGBC.fill = GridBagConstraints.HORIZONTAL;
        inversionPanelGBC.weightx = 1;
        inversionPanelGBC.weighty = 1;
        inversionPanelGBC.gridwidth = 3;
        inversionPanelGBC.gridx = GridBagConstraints.RELATIVE;
        inversionPanelGBC.gridy = 0;
        MoneyAmount = new JSpinner(new SpinnerNumberModel(0.00, 0, 1000000000, 100));
        MoneyAmount.addChangeListener(this);
        MoneyAmount.setName("MoneyAmount");
        inversionPanelForm.add(MoneyAmount, inversionPanelGBC);
        inversionPanelGBC.gridwidth = 1;
        inversionPanelForm.add(new JLabel("$"), inversionPanelGBC);

        inversionPanelGBC.gridwidth = 2;
        inversionPanelForm.add(new JLabel("Tipo de moneda"), inversionPanelGBC);
        inversionPanelGBC.gridwidth = 4;
        TypeOfCurrency = new JComboBox(currency);
        inversionPanelForm.add(TypeOfCurrency, inversionPanelGBC);
        InversionPanel.add(inversionPanelForm, BorderLayout.CENTER);
        JLabel MontoDeInversion = new JLabel("Monto de inversion");
        MontoDeInversion.setHorizontalAlignment(JTextField.CENTER);
        InversionPanel.add(MontoDeInversion, BorderLayout.NORTH);
        InversionPanel.setPreferredSize(new Dimension(titleJPanel.getPreferredSize().width, 100));
        grdibagConstrains.gridheight = 1;
        formEntryContent.add(InversionPanel, grdibagConstrains);

        JPanel housesAndBetNumber = new JPanel(new GridBagLayout());
        GridBagConstraints housesAndBetNumberGBL = new GridBagConstraints();
        // housesAndBetNumberGBL.fill = GridBagConstraints.HORIZONTAL;
        housesAndBetNumberGBL.weightx = 1;
        housesAndBetNumberGBL.weighty = 1;
        housesAndBetNumberGBL.insets = new Insets(5, 5, 5, 5);

        housesAndBetNumberGBL.gridwidth = 2;
        housesAndBetNumberGBL.gridy = 0;
        housesAndBetNumberGBL.gridx = 0;
        JLabel betNumberLabel = new JLabel("Numero de apuestas");
        housesAndBetNumber.add(betNumberLabel, housesAndBetNumberGBL);
        housesAndBetNumberGBL.gridwidth = 3;
        housesAndBetNumberGBL.gridy = 0;
        housesAndBetNumberGBL.gridx = 2;
        NumberOfBets = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        NumberOfBets.setName("NumberOfBets");

        NumberOfBets.addChangeListener(this);

        NumberOfBets.setPreferredSize(new Dimension(200, 30));
        housesAndBetNumber.add(NumberOfBets, housesAndBetNumberGBL);

        housesAndBetNumberGBL.gridwidth = 2;
        housesAndBetNumberGBL.gridy = 1;
        housesAndBetNumberGBL.gridx = 0;
        JLabel betHouseNumberLabel = new JLabel("Numero de casas");
        housesAndBetNumber.add(betHouseNumberLabel, housesAndBetNumberGBL);
        housesAndBetNumberGBL.gridwidth = 3;
        housesAndBetNumberGBL.gridx = 2;
        NumberOfHouses = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        NumberOfHouses.setName("NumberOfHouses");

        NumberOfHouses.addChangeListener(this);

        NumberOfHouses.setPreferredSize(new Dimension(200, 30));
        housesAndBetNumber.add(NumberOfHouses, housesAndBetNumberGBL);

        formEntryContent.add(housesAndBetNumber, grdibagConstrains);

        scrollView.add(formEntryContent, BorderLayout.NORTH);

        JPanel dynamicData = new JPanel(new GridBagLayout());
        GridBagConstraints dynamicDataConstrains = new GridBagConstraints();
        dynamicDataConstrains.fill = GridBagConstraints.HORIZONTAL;
        dynamicDataConstrains.gridx = 0;
        dynamicDataConstrains.gridy = GridBagConstraints.RELATIVE;
        dynamicDataConstrains.insets = new Insets(5, 5, 5, 5);
        dynamicDataConstrains.weightx = 1;
        dynamicDataConstrains.weighty = 1;

        dynamicData.add(HousesNamesInputLayout, dynamicDataConstrains);
        dynamicData.add(betEventsInputs, dynamicDataConstrains);

        scrollView.add(dynamicData, BorderLayout.CENTER);

        scrollViewPanel.setViewportView(scrollView);

        add(scrollViewPanel, BorderLayout.CENTER);

        {// next Step
            JPanel nextButtons = new JPanel(new BorderLayout());
            JPanel buttons = new JPanel(new GridLayout(1, 0));
            JButton Next = new JButton("Siguiente");
            Next.addActionListener(this);
            Next.setActionCommand("Siguiente");
            JButton Close = new JButton("Cancelar");
            Close.addActionListener(this);
            Close.setActionCommand("Cancelar");
            buttons.add(Next);
            buttons.add(Box.createHorizontalStrut(10));
            buttons.add(Close);
            nextButtons.add(buttons, BorderLayout.EAST);

            add(nextButtons, BorderLayout.SOUTH);

        }

        setVisible(true);
    }

    public complexBet getComplexbet() {
        return null;
    }

    private void addHousesNames() {
        for (int e = currentHouseFields + 1; e <= (int) NumberOfHouses.getValue(); e++) {

            JPanel mainSubPanel = new JPanel(new GridBagLayout());
            GridBagConstraints localSubPanelGBC = new GridBagConstraints();

            localSubPanelGBC.fill = GridBagConstraints.HORIZONTAL;
            localSubPanelGBC.gridx = 0;
            localSubPanelGBC.gridy = GridBagConstraints.RELATIVE;
            localSubPanelGBC.insets = new Insets(5, 5, 5, 5);
            localSubPanelGBC.weightx = 1;
            localSubPanelGBC.weighty = 1;

            mainSubPanel.setBorder(BorderFactory.createLineBorder(projectConstants.details));

            JLabel titulo = new JLabel("Casa #" + e);
            titulo.setHorizontalAlignment(JLabel.CENTER);
            titulo.setFont(new Font("", 3, 15));
            mainSubPanel.add(titulo, localSubPanelGBC);

            JLabel JlabelT = new JLabel("Nombre de la casa de apuesta");
            JlabelT.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(JlabelT, localSubPanelGBC);

            JTextField TituloDeLaCasaDeApuestas = new JTextField();
            mainSubPanel.add(TituloDeLaCasaDeApuestas, localSubPanelGBC);

            JLabel LinkLabel = new JLabel("Link web de la casa de apuesta");
            LinkLabel.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(LinkLabel, localSubPanelGBC);

            JTextField LinkDeLaCasaDeApuestas = new JTextField();
            mainSubPanel.add(LinkDeLaCasaDeApuestas, localSubPanelGBC);

            JLabel JLabelCurrentAmount = new JLabel("Saldo de la casa");
            JLabelCurrentAmount.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(JLabelCurrentAmount, localSubPanelGBC);

            JSpinner AmountOfTheHouse = new JSpinner(new SpinnerNumberModel(0.00, 0, 1000000000, 100));
            mainSubPanel.add(AmountOfTheHouse, localSubPanelGBC);

            JLabel TypeOfMomioJL = new JLabel("Tipo de momio");
            TypeOfMomioJL.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(TypeOfMomioJL, localSubPanelGBC);

            JComboBox TypeOfMomioJCB = new JComboBox(projectConstants.TypesOfMomios);
            TypeOfMomioJCB.setPreferredSize(new Dimension(300, 30));
            mainSubPanel.add(TypeOfMomioJCB, localSubPanelGBC);

            HousesNamesInputLayout.add(mainSubPanel, localSubPanelGBC);

            currentHouseFields++;
            BetHouseLinks.add(LinkDeLaCasaDeApuestas);
            BetHouseTitles.add(TituloDeLaCasaDeApuestas);
            MoneyBalanceInEveryHouse.add(AmountOfTheHouse);
            TypeOfMomioInEveryHouse.add(TypeOfMomioJCB);
        }

        for (int e = currentHouseFields; e > (int) NumberOfHouses.getValue() && currentHouseFields > 0; e--) {
            HousesNamesInputLayout.remove(e - 1);
            BetHouseLinks.remove(e - 1);
            BetHouseTitles.remove(e - 1);
            TypeOfMomioInEveryHouse.remove(e - 1);
            currentHouseFields--;

        }

        this.paintAll(this.getGraphics());

    }

    private void addBetEvents() {
        for (int e = currentEventFields + 1; e <= (int) NumberOfBets.getValue(); e++) {

            JPanel mainSubPanel = new JPanel(new GridBagLayout());

            GridBagConstraints localSubPanelGBC = new GridBagConstraints();
            ButtonGroup selectedFavoritePlayer = new ButtonGroup();

            localSubPanelGBC.fill = GridBagConstraints.HORIZONTAL;
            localSubPanelGBC.gridx = 0;
            localSubPanelGBC.gridy = GridBagConstraints.RELATIVE;
            localSubPanelGBC.insets = new Insets(5, 5, 5, 5);
            localSubPanelGBC.weightx = 1;
            localSubPanelGBC.weighty = 1;

            GridBagConstraints fieldsGBC = new GridBagConstraints();
            fieldsGBC.insets = new Insets(5, 5, 5, 5);
            fieldsGBC.weightx = 1;
            fieldsGBC.weighty = 1;

            mainSubPanel.setBorder(BorderFactory.createLineBorder(projectConstants.details));

            fieldsGBC.gridx = 0;
            fieldsGBC.gridy = 0;
            JLabel titulo = new JLabel("Evento #" + e);
            titulo.setHorizontalAlignment(JLabel.CENTER);
            titulo.setFont(new Font("", 3, 15));
            mainSubPanel.add(titulo, fieldsGBC);

            fieldsGBC.gridx = 0;
            fieldsGBC.gridy = 1;
            JLabel JlabelT = new JLabel("Jugador 1");
            JlabelT.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(JlabelT, fieldsGBC);

            fieldsGBC.gridx = 1;
            fieldsGBC.gridy = 1;
            JTextField player1 = new JTextField();
            player1.setPreferredSize(new Dimension(300, 30));
            mainSubPanel.add(player1, fieldsGBC);

            fieldsGBC.gridx = 2;
            fieldsGBC.gridy = 1;
            JRadioButton favoritePlayer1 = new JRadioButton();
            favoritePlayer1.setActionCommand("favoritePlayer1");
            selectedFavoritePlayer.add(favoritePlayer1);
            mainSubPanel.add(favoritePlayer1, fieldsGBC);

            fieldsGBC.gridx = 0;
            fieldsGBC.gridy = 2;
            JLabel LinkLabel = new JLabel("Jugador 2");
            LinkLabel.setHorizontalAlignment(JLabel.CENTER);
            mainSubPanel.add(LinkLabel, fieldsGBC);

            fieldsGBC.gridx = 1;
            fieldsGBC.gridy = 2;
            JTextField Player2 = new JTextField();
            Player2.setPreferredSize(new Dimension(300, 30));
            mainSubPanel.add(Player2, fieldsGBC);

            fieldsGBC.gridx = 2;
            fieldsGBC.gridy = 2;
            JRadioButton favoritePlayer2 = new JRadioButton();
            selectedFavoritePlayer.add(favoritePlayer2);
            favoritePlayer2.setActionCommand("favoritePlayer2");
            mainSubPanel.add(favoritePlayer2, fieldsGBC);

            betEventsInputs.add(mainSubPanel, localSubPanelGBC);

            selectedFavoritePlayer.setSelected(favoritePlayer1.getModel(), true);
            currentEventFields++;
            Players2.add(Player2);
            Players1.add(player1);
            favoritePlayers.add(selectedFavoritePlayer);
            EventsNames.add("Evento #" + e);

        }

        for (int e = currentEventFields; e > (int) NumberOfBets.getValue() && currentEventFields > 0; e--) {
            betEventsInputs.remove(e - 1);
            Players2.remove(e - 1);
            Players1.remove(e - 1);
            EventsNames.remove(e - 1);
            currentEventFields--;

        }

        this.paintAll(this.getGraphics());

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        // TODO Auto-generated method stub
        switch (((JSpinner) e.getSource()).getName()) {
            case "NumberOfHouses":
                addHousesNames();
                break;
            case "NumberOfBets":
                addBetEvents();

                break;
        }
    }

    // ALL TO SECOND STAGE /////////////////////////////
    private ArrayList<indvBet> parseEventsFromInputs() {
        ArrayList<indvBet> simpleBets = new ArrayList<indvBet>();

        for (int e = 0; e < currentEventFields; e++) {

            String player1String = Players1.get(e).getText().isEmpty() ? "Player " + (e + 1) + ".1"
                    : Players1.get(e).getText();
            String player2String = Players2.get(e).getText().isEmpty() ? "Player " + (e + 1) + ".2"
                    : Players2.get(e).getText();
            ButtonGroup favoritePlayerButtonGroup = favoritePlayers.get(e);
            int favoritePlayer = favoritePlayerButtonGroup.getSelection().getActionCommand() == "favoritePlayer1" ? 1
                    : 2;
            indvBet newinIndvBet = new indvBet(EventsNames.get(e), player1String, player2String, favoritePlayer);
            simpleBets.add(newinIndvBet);

        }
        return simpleBets;
    }

    private ArrayList<betHouse> parse_betHouses() {
        ArrayList<betHouse> betHouses = new ArrayList<betHouse>();
        for (int e = 0; e < currentHouseFields; e++) {

            String HouseString = BetHouseTitles.get(e).getText().isEmpty() ? "Casa de apuestas " + (e + 1)
                    : BetHouseTitles.get(e).getText();
            String HouseLink = BetHouseLinks.get(e).getText().isEmpty() ? "www.casaFalsa" + (e + 1) + ".com"
                    : BetHouseLinks.get(e).getText();

            MomioType momio = null;
            String TypeOfMomio = ((String) TypeOfMomioInEveryHouse.get(e).getSelectedItem()).isEmpty()
                    ? "www.casaFalsa" + (e + 1) + ".com"
                    : ((String) TypeOfMomioInEveryHouse.get(e).getSelectedItem());
            switch (TypeOfMomio) {
                case "Americano":
                    momio = MomioType.Americano;
                    break;
                case "Decimal":
                    momio = MomioType.Decimal;

                    break;
                case "Probabilidad Implicita":
                    momio = MomioType.ProbabilidadImplicita;

                    break;
                case "Fraccionario":
                    momio = MomioType.Fraccionario;
                    break;
            }
            betHouse newBetHouse = new betHouse(HouseString, HouseLink,
                    (Double) MoneyBalanceInEveryHouse.get(e).getValue(), momio);
            betHouses.add(newBetHouse);
        }
        return betHouses;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch (e.getActionCommand()) {

            case "Siguiente":
                new secondStage(parse_betHouses(), parseEventsFromInputs());
                break;
            case "Cancelar":

                break;
        }

    }

}
