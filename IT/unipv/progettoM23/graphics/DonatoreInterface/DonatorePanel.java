package IT.unipv.progettoM23.graphics.DonatoreInterface;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.*;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.graphics.ContainerPanel;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.prenotazioni.Prenotazione;
import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;


public class DonatorePanel extends JPanel{
    
	private JLabel testo;
	private ContainerPanel cp;
	private JButton indietro,prenota,cancella;
	
	public DonatorePanel(Donatore d) {
		
		this.setLayout(new GridLayout(0,1));
		
        this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		testo=new JLabel("Ciao "+d.getNome()+" "+d.getCognome()+"!");
		testo.setFont(new Font("Serif",Font.PLAIN,50));
		//testo.setPreferredSize();
		testo.setForeground(white);
		cp.add(testo);
		this.add(cp);
		
		
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		testo=new JLabel("Queste sono le tue ultime donazioni:    ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
		testo.setForeground(white);
		cp.add(testo);

		////// crea JList 
		
		DefaultListModel<Date> dlm=new DefaultListModel<>();
		
		DonazioneDAO dDAO = new DonazioneDAO();
		ArrayList<Donazione> donazioni = dDAO.selectDonazioni(d.getcodFiscale());
        
		
		
        for(Donazione don:donazioni) {
        	dlm.addElement(don.getData());
        }
		
		JList<Date> lista=new JList<>(dlm);
		JScrollPane scrollPane = new JScrollPane(lista);
		
	    cp.add(scrollPane);
	    
    	this.add(cp);
    	
    	
    	
    	
    	
    	
    	cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		testo=new JLabel("Premi per prenotare una donazione  ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
		testo.setForeground(white);
        cp.add(testo);
        
        prenota=new JButton("Prenota");
        cancella=new JButton("Cancella");
        
        cp.add(prenota);
        cp.add(cancella);
        
        this.add(cp);
        
        
    	
        
        PrenotazioneDAO p = new PrenotazioneDAO();
		Prenotazione p1;
		p1 = p.selectUltimaPrenotazione(d.getcodFiscale());
    	
        cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
    	testo=new JLabel("La tua prossima donazione:   "+p1.getData()+"   alle:   "+p1.getOra());
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
		testo.setForeground(white);
        cp.add(testo);  
        
        
        
        this.add(cp);
    	
    	
    
    	
		
	}
}
