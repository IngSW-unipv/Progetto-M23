package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.*;

import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;

public class VisualPrenotazioniPanel extends JPanel{
	
	private JLabel testo;
	private ContainerPanel cp,container;
	private JButton indietro,cerca;
	private JTextField giornoTF,meseTF,annoTF;
	private JTable table;

    
	public VisualPrenotazioniPanel() {
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		LocalDate todayLD =LocalDate.now();
		Date today=Date.valueOf(todayLD);
		
		
		
		
		//// definisce i componenti della riga in alto //////////////////////////////
		
		container=new ContainerPanel(new GridLayout(0,3));
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
		indietro =new JButton("Indietro");
		cp.add(indietro);
		
	    container.add(cp);

	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("cerca al giorno : ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    giornoTF=new JTextField(2);
	    meseTF=new JTextField(2);
	    annoTF=new JTextField(4);
	    
	    cp.add(giornoTF);
	    cp.add(meseTF);
	    cp.add(annoTF);
	    
	    container.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));
		
		cerca =new JButton("Cerca");
		cp.add(cerca);
		
	    container.add(cp);

	    
	    this.add(container,BorderLayout.NORTH);
	    
	    
	    
	    
	    
	    
	    
	    
	    ////// definisce i componenti nel centro //////////////////////
	    
	    
	    //container=new ContainerPanel(new GridLayout());
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel(" Prenotazioni Di Oggi ("+today+") :");
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo,BorderLayout.NORTH);
	    
	    
	    PrenotazioneDAO pd=new PrenotazioneDAO();
		String[] colonne= {"Codice Fiscale","Orario"};
		//String[][] dati= pd.getArrayPrenotazioni(today);
		
		String[][] dati= {
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
				{"kekeokeplekkfe","08:30"},
		};
		
		
		table= new JTable(dati,colonne);
		table.setPreferredSize(new Dimension(250,400));
		
	
		if(dati.length!=0) {
		    table.setRowHeight(400/dati.length);
		}
		
		cp.add(table,BorderLayout.CENTER);
	
		this.add(cp,BorderLayout.CENTER);
		
		
	}
	
	
}
