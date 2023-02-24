package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.*;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.prenotazioni.Prenotazione;
import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;


public class DonatorePanel extends CartaPanel{
    
	//private Donatore d;
	private JLabel testo,saluto,testoPren;
	private ContainerPanel cp;
	private JButton indietro,prenota,cancella;
	private JList<Date> lista;
	private DefaultListModel<Date> dlm;
	private JScrollPane scrollPane;
	
	
	//ArrayList<Donazione> donazioni;
	
	
	public DonatorePanel() {
		
		//d=new Donatore ("TTTTTTTTTTTTTTTT","ROSSI", "MARIO",Date.valueOf("2001-01-01") ,"M", GruppoSanguigno.ZERO );    ////////// da cambiare con donatore passato da controller
		
		this.setKey("utente");
		
		this.setLayout(new GridLayout(0,1));
		
        this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		saluto=new JLabel();
//	    saluto.setText();
		saluto.setFont(new Font("Serif",Font.PLAIN,50));
		//testo.setPreferredSize();
		saluto.setForeground(white);
		cp.add(saluto);
		this.add(cp);
		
		
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		testo=new JLabel("Queste sono le tue donazioni:    ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
		testo.setForeground(white);
		cp.add(testo);

		
		////// crea JList 
		
		dlm=new DefaultListModel<>();
		
		//DonazioneDAO dDAO = new DonazioneDAO();
		//ArrayList<Donazione> donazioni = dDAO.selectDonazioni(d.getcodFiscale());
		
		lista=new JList<>(dlm);
		scrollPane = new JScrollPane(lista);
		
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
        
        
    	
        
        //PrenotazioneDAO p = new PrenotazioneDAO();
		//Prenotazione p1;
		//p1 = p.selectUltimaPrenotazione(d.getcodFiscale());
    	
        cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
    	testoPren=new JLabel();
    	testoPren.setFont(new Font("Dialog",Font.PLAIN,20));
    	testoPren.setForeground(white);
        cp.add(testoPren);  
        
        
        
        this.add(cp);
	}
	
	
	
	
	
	
	public JLabel getSaluto() {
		return this.saluto;
	}
	
	public JLabel getTestoPren() {
		return this.testoPren;
	}
	
	public void changeSaluto(String n,String c) {
		this.getSaluto().setText("Ciao "+n+" "+c+"!");
		this.getSaluto().paintImmediately(this.getSaluto().getVisibleRect());
	}
	
	public void changeTestoPren(Prenotazione p1) {
		
		if (p1!=null) {
			this.getTestoPren().setText("La tua prossima donazione:   "+p1.getData()+"   alle:   "+p1.getOra());
			this.getTestoPren().paintImmediately(this.getTestoPren().getVisibleRect());
		}
		else {
			this.getTestoPren().setText("Nessuna prenotazione");
			this.getTestoPren().paintImmediately(this.getTestoPren().getVisibleRect());			
		}
	}
	
	
	
	public void changeDonazioni(ArrayList<Donazione> listaDon) {
		dlm=new DefaultListModel<>();
		
		if (listaDon!=null) {
	        for(Donazione don:listaDon) {
	        	dlm.addElement(don.getData());
	        }
		}
		
		lista.setModel(dlm);
	}
	
	
	
//	public void setNome(String n) {
//		this.nome=n;
//	}
//	public void setCognome(String c) {
//		this.cognome=c;
//	}
//    public void setPrenotazione(Prenotazione p) {
//    	this.p1=p;
//    }
    
    public JButton getPrenotaButton() {
    	return this.prenota;
    }
	
    public JButton getCancellaButton() {
    	return this.cancella;
    }
    
//    public void setDonazioni(ArrayList<Donazione> a) {
//    	this.donazioni=a;
//    }
    
    public JScrollPane getListaPanel() {
    	return this.scrollPane;
    }
    
	public JButton getIndietroButton() {
		return indietro;
	}
}
