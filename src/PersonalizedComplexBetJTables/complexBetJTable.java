package PersonalizedComplexBetJTables;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class complexBetJTable extends JPanel implements MouseListener {
	private JTable table;
	private ComplexBetTableModel tableModel;
	private String[] headers = {
			"Numero",
			"Nombre",
			"Descripcion",
			"Apuestas Activas",
			"Margen Ganancia",
			"Probabilidad de ganar",
			"Status",
	};
	private ArrayList<complexBet> dataComplexbet = new ArrayList<complexBet>();

	private Object[][] dataComplexbetToArrayData() {

		Object returnArray[][] = new Object[dataComplexbet.size()][7];
		for (int e = 0; e < dataComplexbet.size(); e++) {
			returnArray[e] = dataComplexbetToRow(dataComplexbet.get(e));
		}
		return returnArray;
	}

	private Object[] dataComplexbetToRow(complexBet newComplexbet) {
		Object returnArray[] = new Object[7];
		// returnArray[0] = newComplexbet.getNumber();
		// returnArray[1] = newComplexbet.getName();
		// returnArray[2] = newComplexbet.getDescription();
		// returnArray[3] = newComplexbet.getActivesBets();
		// returnArray[4] = newComplexbet.getProfitPercentage();
		// returnArray[5] = newComplexbet.getWinnintProbability();
		// returnArray[6] = newComplexbet.getStatus();
		return returnArray;
	}

	public void addComplexBetEntry(complexBet complexBeat) {
		dataComplexbet.add(complexBeat);
		tableModel.addRow(dataComplexbetToRow(complexBeat));

	}

	/**
	 * Create the panel.
	 */
	public complexBetTable() {
		setLayout(new BorderLayout());

		JScrollPane scrollPaneTabla = new JScrollPane();

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.addMouseListener(this);
		table.setOpaque(false);
		scrollPaneTabla.setViewportView(table);

		tableModel = new ComplexBetTableModel(dataComplexbetToArrayData(), headers);
		table.setModel(tableModel);

		int filasTabla = table.getRowCount();
		int columnasTabla = table.getColumnCount();

		table.getColumnModel().getColumn(0).setCellRenderer(new ComplexBetTableCells("num"));
		table.getColumnModel().getColumn(1).setCellRenderer(new ComplexBetTableCells("text"));
		table.getColumnModel().getColumn(2).setCellRenderer(new ComplexBetTableCells("text"));
		table.getColumnModel().getColumn(3).setCellRenderer(new ComplexBetTableCells("num"));
		table.getColumnModel().getColumn(4).setCellRenderer(new ComplexBetTableCells("num"));
		table.getColumnModel().getColumn(5).setCellRenderer(new ComplexBetTableCells("num"));
		table.getColumnModel().getColumn(6).setCellRenderer(new ComplexBetTableCells("color"));
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(25);// tamaño de las celdas
		table.setGridColor(new java.awt.Color(0, 0, 0));

		JTableHeader jtableHeader = table.getTableHeader();
		jtableHeader.setDefaultRenderer(new ComplexBetTableHeaders());
		table.setTableHeader(jtableHeader);

		// se asigna la tabla al scrollPane
		scrollPaneTabla.setViewportView(table);

		add(scrollPaneTabla, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
