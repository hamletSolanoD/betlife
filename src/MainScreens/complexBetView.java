package MainScreens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import interfaces.projectConstants;
import logicComponents.complexBet;
import personalizedComplexBetEntries.complexBetTable;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import ComplexBet.firstStage;

public class complexBetView extends JPanel implements ActionListener {

	complexBetTable ComplexBetTable;

	private void initializeTable() {
		// ComplexBetTable.addComplexBetEntry(new complexBet(1, "Nueva Apuesta",
		// "Apuesta de prueba", 5, 0.50f, 0.10f,
		// projectConstants.statusComplexbet.CANCELLED));
		// ComplexBetTable.addComplexBetEntry(new complexBet(1, "Nueva Apuesta",
		// "Apuesta de prueba", 5, 0.50f, 0.10f,
		// projectConstants.statusComplexbet.CANCELLED));
		// ComplexBetTable.addComplexBetEntry(new complexBet(1, "Nueva Apuesta",
		// "Apuesta de prueba", 5, 0.50f, 0.10f,
		// projectConstants.statusComplexbet.COMPLETED));
		// ComplexBetTable.addComplexBetEntry(new complexBet());
		// ComplexBetTable.addComplexBetEntry(new complexBet());
		// ComplexBetTable.addComplexBetEntry(new complexBet(1, "Nueva Apuesta",
		// "Apuesta de prueba", 5, 0.50f, 0.10f,
		// projectConstants.statusComplexbet.CANCELLED));

	}

	public complexBetView() {
		setLayout(new BorderLayout());

		JPanel northLayout = new JPanel(new BorderLayout());
		JLabel tittle = new JLabel("Complex Bet");
		tittle.setFont(projectConstants.titleFont);
		tittle.setHorizontalAlignment(JLabel.CENTER);
		northLayout.add(tittle, BorderLayout.NORTH);

		JToolBar toolBar = new JToolBar();

		JPanel textSearchPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagSearch = new GridBagConstraints();

		gridBagSearch.gridy = 0;
		gridBagSearch.gridx = GridBagConstraints.RELATIVE;
		gridBagSearch.gridwidth = 2;
		gridBagSearch.insets = new Insets(10, 10, 10, 10);
		textSearchPanel.add(new JLabel("Search:"), gridBagSearch);
		gridBagSearch.gridwidth = 3;
		JTextField jTextField = new JTextField();
		jTextField.setText("Search...			");
		jTextField.setMinimumSize(new Dimension(100, 100));
		textSearchPanel.add(jTextField, gridBagSearch);

		JPanel dateSearchPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagDate = new GridBagConstraints();
		gridBagDate.gridwidth = 2;
		gridBagDate.gridy = 0;
		gridBagDate.insets = new Insets(10, 10, 10, 10);
		dateSearchPanel.add(new JLabel("Start Date"), gridBagDate);
		gridBagDate.gridwidth = 1;
		JButton startDateButtonFilter = new JButton("D");
		dateSearchPanel.add(startDateButtonFilter, gridBagDate);

		gridBagDate.gridwidth = 2;
		dateSearchPanel.add(new JLabel("End Date"), gridBagDate);
		gridBagDate.gridwidth = 1;
		JButton endDateButtonFilter = new JButton("D");
		dateSearchPanel.add(endDateButtonFilter, gridBagDate);

		ComplexBetTable = new complexBetTable();

		JPanel createNewTableEntry = new JPanel(new BorderLayout());
		JButton newEntry = new JButton("Crear");
		newEntry.addActionListener(this);
		newEntry.setActionCommand("newEntry");
		createNewTableEntry.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
		createNewTableEntry.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
		createNewTableEntry.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		createNewTableEntry.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
		createNewTableEntry.add(newEntry, BorderLayout.CENTER);

		toolBar.add(textSearchPanel);
		toolBar.add(dateSearchPanel);
		toolBar.add(createNewTableEntry);
		northLayout.add(toolBar, BorderLayout.CENTER);

		add(northLayout, BorderLayout.NORTH);
		add(ComplexBetTable, BorderLayout.CENTER);

		initializeTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
			case "newEntry":
				complexBet newEntry = (new firstStage((JFrame) SwingUtilities.getRoot(this))).getComplexbet();
				if (newEntry != null) {
					ComplexBetTable.addComplexBetEntry(newEntry);
				} else {
					// error general
				}

				break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
		}

	}

}
