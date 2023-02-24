package IT.unipv.progettoM23.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import IT.unipv.progettoM23.ospedale.RichiestaSaccaDAO;

public class RichiestePanel extends CartaPanel{
 
	
	private JTable table;
	private JButton indietro;
	private ContainerPanel cp;
	
	
	public RichiestePanel() {
		
		this.setKey("richieste");
		
	    this.setLayout(new BorderLayout());
	    
	    this.setBackground(new Color(100,0,0));
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp,BorderLayout.NORTH);
	    

	    table = new JTable();
	    JScrollPane scrollPane = new JScrollPane(table);
	
	    this.add(scrollPane,BorderLayout.CENTER);
	    
	}
	
	
	public void visualizzaRichieste(String[][] dati) {
		
		String[] colonne= {"CF paziente","Gruppo", "Quantità" };
		
		DefaultTableModel tabModel =new DefaultTableModel(dati,colonne);
		
		this.table.setModel(tabModel);
		
	}
	
	
	
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }
  }
