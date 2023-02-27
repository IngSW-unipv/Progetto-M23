package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.sql.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PrenGiornoPanel extends CartaPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel testo;
	private ContainerPanel cp;
	private JTable table;
	private JButton indietro;


	
	public PrenGiornoPanel() {
		
		this.setKey("prenotazioniGiorno");
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
				
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp,BorderLayout.NORTH);
	
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("  Prenotazioni del giorno  ");
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    testo.setForeground(white);
	    cp.add(testo);
		

	    
		
		table= new JTable();
		table.setPreferredSize(new Dimension(250,500));
		
		table.setEnabled(false);
	
		
		cp.add(table);
		
		
		this.add(cp,BorderLayout.CENTER);
	}
	
	
	
	public void visualizzaPrenotazioni(String[][] dati) {
		String[] colonne= {"Codice Fiscale","Orario"};
		
		DefaultTableModel tabModel =new DefaultTableModel(dati,colonne);
		
		this.table.setModel(tabModel);
		
		if(table.getRowCount()!=0) {
		    table.setRowHeight((int) (table.getPreferredSize().getHeight()/table.getRowCount()));
		}
	}
	
	
	
	public void visualizzaGiorno(Date d) {
		
		this.testo.setText("  Prenotazioni del giorno  "+d+" :");
		this.testo.paintImmediately(this.testo.getVisibleRect());
	}
	
	
	
	public String getSelectedValueOfTable() {
		String res= (String)this.table.getValueAt(this.table.getSelectedRow(),0);
		
		return res;
	}
	
	
	
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }

}
