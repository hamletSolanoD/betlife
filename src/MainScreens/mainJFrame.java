package screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import interfaces.*;
import javax.swing.JSplitPane;
public class MainJFrame extends JFrame implements ActionListener{

	private JSplitPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel leftPanel = new leftPanel(this);
	private ComplexBetView complexBetView = new ComplexBetView();
	private GeneralStatsView generalStatsView = new GeneralStatsView();

	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)(projectConstants.screenWidth/8)*7, (int)(projectConstants.screenHeight/8)*7);
		contentPane =  new JSplitPane();
		contentPane.setLeftComponent(leftPanel);
		contentPane.setRightComponent(generalStatsView);
		contentPane.setBackground(projectConstants.background);
		
	
		
		
		

		setContentPane(contentPane);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
			}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "GeneralStats": 		contentPane.setRightComponent(generalStatsView);
break;


		case "ComplexBet":		contentPane.setRightComponent(complexBetView);
 break;

		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
		this.paintAll(this.getGraphics());
		
	}


}
