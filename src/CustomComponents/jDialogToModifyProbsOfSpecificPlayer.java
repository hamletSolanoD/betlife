package CustomComponents;

import javax.swing.JDialog;

import interfaces.projectConstants;

import interfaces.projectConstants.MomioType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class jDialogToModifyProbsOfSpecificPlayer extends JDialog implements ActionListener {

    private JSpinner newPlayerProbValue;
    private JComboBox type;

    private String TypesOfMomios[] = { "Americano", "Decimal", "Fraccionario", "Probabilidad Implicita" };

    public jDialogToModifyProbsOfSpecificPlayer(String betHouse, String playerName, JFrame Context,
            ActionListener object) {
        super(Context);
        setBounds(0, 0, projectConstants.screenWidth / 3, (projectConstants.screenHeight / 4));
        setLayout(new BorderLayout());

        JPanel LocalJPanel = new JPanel(new GridBagLayout());
        GridBagConstraints localGBC = new GridBagConstraints();
        localGBC.insets = new Insets(5, 5, 5, 5);
        localGBC.weightx = 1;
        localGBC.weighty = 1;

        localGBC.gridx = 0;
        localGBC.gridy = 0;
        localGBC.gridwidth = 2;

        localGBC.fill = GridBagConstraints.HORIZONTAL;
        JLabel houseTittle = new JLabel(betHouse);
        houseTittle.setHorizontalAlignment(JLabel.CENTER);
        LocalJPanel.add(houseTittle, localGBC);

        localGBC.fill = GridBagConstraints.NONE;
        localGBC.gridwidth = 1;

        localGBC.gridx = 0;
        localGBC.gridy = 1;
        JLabel TypeOfMomioJL = new JLabel("Tipo de momio");
        LocalJPanel.add(TypeOfMomioJL, localGBC);

        localGBC.gridx = 1;
        localGBC.gridy = 1;
        JComboBox TypeOfMomioJCB = new JComboBox(TypesOfMomios);
        TypeOfMomioJCB.setPreferredSize(new Dimension(300, 30));
        LocalJPanel.add(TypeOfMomioJCB, localGBC);

        localGBC.gridx = 0;
        localGBC.gridy = 2;
        JLabel Player1JL = new JLabel(playerName);
        LocalJPanel.add(Player1JL, localGBC);

        localGBC.gridx = 1;
        localGBC.gridy = 2;
        JSpinner player1TextField = new JSpinner(new SpinnerNumberModel(0.00, -1000, 1000, 1));
        player1TextField.setPreferredSize(new Dimension(300, 30));
        LocalJPanel.add(player1TextField, localGBC);

        newPlayerProbValue = player1TextField;
        type = TypeOfMomioJCB;

        add(LocalJPanel, BorderLayout.CENTER);

        {// next Step
            JPanel nextButtons = new JPanel(new BorderLayout());
            JPanel buttons = new JPanel(new GridLayout(1, 0));

            JButton Next = new JButton("Aceptar");
            Next.addActionListener(object);
            Next.setActionCommand("Aceptarmod");

            buttons.add(Box.createHorizontalStrut(10));
            buttons.add(Next);

            nextButtons.add(buttons, BorderLayout.EAST);

            add(nextButtons, BorderLayout.SOUTH);

        }

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public double getNewProbValue() {

        return (double) newPlayerProbValue.getValue();
    }

    public projectConstants.MomioType getTypeOfMomio() {
        switch ((String) type.getSelectedItem()) {
            case "Americano":
                return MomioType.Americano;
            case "Decimal":
                return MomioType.Decimal;
            case "Fraccionario":
                return MomioType.Fraccionario;
            case "Probabilidad Implicita":
                return MomioType.ProbabilidadImplicita;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Cancelar":
                newPlayerProbValue.setValue(0);
                type.setSelectedItem(null);
                dispose();
                break;
            case "Siguiente":
                dispose();
                break;

        }

    }
}
