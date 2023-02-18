package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.sql.Date;

import javax.swing.*;

import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;

public class PrenGiornoPanel extends JPanel {
	
	private JLabel testo;
	private ContainerPanel cp;
	private JTable table;
	private JButton indietro;
	private Date d;

	
	public PrenGiornoPanel() {
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		
		d=Date.valueOf("2001-01-01");  /////////////////////////// da cabiare con data passata da controller
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp,BorderLayout.NORTH);
		
		
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("  Prenotazioni del giorno  "+d+" :");
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    
	    PrenotazioneDAO pd=new PrenotazioneDAO();
		String[] colonne= {"Codice Fiscale","Orario"};
		String[][] dati= pd.getArrayPrenotazioni(d);
		
		//String[][] dati= {{"jeidjwojo","8:30"},{"jeidjwojo","8:30"},{"jeidjwojo","8:30"},{"jeidjwojo","8:30"},{"jeidjwojo","8:30"},{"jeidjwojo","8:30"}};

		
		table= new JTable(dati,colonne);
		table.setPreferredSize(new Dimension(250,500));
		
		table.setEnabled(false);
		
	
		if(table.getRowCount()!=0) {
		    table.setRowHeight((int) (table.getPreferredSize().getHeight()/table.getRowCount()));
		}
		
		cp.add(table);
		
		
		this.add(cp,BorderLayout.CENTER);
	}

}
