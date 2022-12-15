package screens;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GeneralStatsView extends JPanel {

	/**
	 * Create the panel.
	 */
	public GeneralStatsView() {
		setLayout(new BorderLayout());
		JLabel tittle = new JLabel("General Stats View");
		add(tittle, BorderLayout.NORTH);


	}

}
