package IT.unipv.progettoM23.graphics;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class RichiestePanel extends CartaPanel{
 
	private static final long serialVersionUID = 1L;
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
