package personalizedComplexBetEntries;

import javax.swing.table.DefaultTableModel;

public class ComplexBetTableModel extends DefaultTableModel {

	 String[] titulos;
	 Object[][] datos;
	 
	//
	// Determina el modelo con el que se va a construir la tabla
	// @param datos
	// @param titulos
	//
	 public ComplexBetTableModel(Object[][] datos, String[] titulos) {
	  super();
	  this.titulos=titulos;
	  this.datos=datos;
	  setDataVector(datos, titulos);
	 }
	 
	 public ComplexBetTableModel() {
	  // TODO Auto-generated constructor stub
	 }

	 public boolean isCellEditable (int row, int column)
	 {
	 return false;
	 }
}
