package personalizedComplexBetEntries;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import interfaces.projectConstants;

public class ComplexBetTableCells extends DefaultTableCellRenderer {
	 
	 private String tipo;

	 //se definen por defecto los tipos de datos a usar
	 private Font normal = new Font( "Verdana",Font.PLAIN ,12 );
	 private Font bold = new Font( "Verdana",Font.BOLD ,12 );
	 //etiqueta que almacenará el icono a mostrar
	 private JLabel label = new JLabel();
	 //iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
	
	//
	//constructor explicito con el tipo de dato que tendrá la celda
	// @param tipo
	//
	 public ComplexBetTableCells(String tipo){
	  this.tipo=tipo;
	 }

	 @Override
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
	  
	        Color colorFondo = null;
	        Color colorFondoPorDefecto=new Color( 192, 192, 192);
	        Color colorFondoSeleccion=new Color( 140, 140 , 140);
	    
	        if (selected) {                
	            this.setBackground(colorFondoPorDefecto );   
	        }
	        else
	        {
	         
	            this.setBackground(Color.white);
	        }
	
	        
	        
	        
	        if( tipo.equals("text"))
	        {
	        	//System.out.println(value);

	            if (focused) {
	       colorFondo=colorFondoSeleccion;
	      }else{
	       colorFondo= colorFondoPorDefecto;
	      }
	            this.setHorizontalAlignment( JLabel.CENTER );
	            this.setText( value.toString().substring(0, value.toString().length() < 35 ?value.toString().length()-1: 35 ) );
	            this.setBackground( (selected)? colorFondo :Color.WHITE); 
	            this.setFont(new Font("",3,10));   
	            return this;
	        }
	        
	        
	        
	        if( tipo.equals("num"))
	        {
	         if (focused) {
	        colorFondo=colorFondoSeleccion;
	       }else{
	        colorFondo=colorFondoPorDefecto;
	       }
	         // //System.out.println(value);
	            this.setHorizontalAlignment( JLabel.CENTER );
	            this.setText(  value.toString() );            
	            this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );    
	            this.setBackground( (selected)? colorFondo :Color.WHITE);
	           // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
	            this.setFont(bold);            
	            return this;   
	        }
	        
	        
	        if( tipo.equals("color"))
	        {
	         if (focused) {
	        colorFondo=colorFondoSeleccion;
	       }else{
	        colorFondo=colorFondoPorDefecto;
	       }
	         // //System.out.println(value);
	            this.setHorizontalAlignment( JLabel.CENTER );
	            this.setText(  value.toString() );            
	            this.setForeground( ((projectConstants.statusComplexbet)value ).getColor());    
	            this.setBackground( ((projectConstants.statusComplexbet)value ).getColor());    
	            this.setFont(bold);            
	            return this;   
	        }
	        
	        
	        
	  
	  return this; 
	 }
	}