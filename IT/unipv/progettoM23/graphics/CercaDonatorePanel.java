package IT.unipv.progettoM23.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class CercaDonatorePanel extends CartaPanel{
	
	private JLabel nome,cognome,cf,dob,sesso,gruppo,donazioni;
	private ContainerPanel cp;
	private JButton indietro;
	private Donatore d;
	private JList<Date> lista;
	private DefaultListModel<Date> dlm;
	private JScrollPane scrollPane;
	
	
	
	public CercaDonatorePanel() {
		
		this.setKey("mostraDonatore");
		
		d=new Donatore ("TTTTTTTTTTTTTTTT","ROSSI", "MARIO",Date.valueOf("2001-01-01") ,"M", GruppoSanguigno.ZERO );    ////////// da cambiare con donatore passato da controller

		
        this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    cognome = new JLabel();
	    cognome.setForeground(white);
	    cognome.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(cognome);
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    nome = new JLabel();
	    nome.setForeground(white);
	    nome.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(nome);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    cf = new JLabel();
	    cf.setForeground(white);
	    cf.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(cf);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
		donazioni = new JLabel("    Donazioni:  ");
		donazioni.setForeground(white);
		donazioni.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(donazioni);
	    
	    
	    
	    
		dlm=new DefaultListModel<>();
		
		lista=new JList<>(dlm);
		scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(new Dimension(100,50));
		
	    cp.add(scrollPane);
	    
    	this.add(cp);
    	
    	
    	
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    dob = new JLabel();
	    dob.setForeground(white);
	    dob.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(dob);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    sesso = new JLabel();
	    sesso.setForeground(white);
	    sesso.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(sesso);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    gruppo = new JLabel();
	    gruppo.setForeground(white);
	    gruppo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(gruppo);
	    
	    this.add(cp);
	    
	   
    	
    	//cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
    	//this.add(cp);
		
	}
	
	
	public JLabel getNomeLabel() {
		return this.nome;
	}
	
	public JLabel getCognomeLabel() {
		return this.cognome;
	}
	
	public JLabel getSessoLabel() {
		return this.sesso;
	}
	
	public JLabel getGruppoLabel() {
		return this.gruppo;
	}
	
	public JLabel getDOBLabel() {
		return this.dob;
	}
	
	public JLabel getCFLabel() {
		return this.cf;
	}
	
	
	
	public void changeDati(String n,String c,String cf,String dob,String s,String g) {
		
		this.getNomeLabel().setText("    Nome: "+n);
		this.getNomeLabel().paintImmediately(this.getNomeLabel().getVisibleRect());
		
		this.getCognomeLabel().setText("    Cognome: "+c);
		this.getCognomeLabel().paintImmediately(this.getCognomeLabel().getVisibleRect());
		
		this.getCFLabel().setText("    CodiceFiscale: "+cf);
		this.getCFLabel().paintImmediately(this.getCFLabel().getVisibleRect());
		
		this.getDOBLabel().setText("    Data di Nascita(AAAA/MM/GG): "+dob);
		this.getDOBLabel().paintImmediately(this.getDOBLabel().getVisibleRect());
		
		this.getSessoLabel().setText("    Sesso: "+s);
		this.getSessoLabel().paintImmediately(this.getSessoLabel().getVisibleRect());
		
		this.getGruppoLabel().setText("    Gruppo: "+g);
		this.getGruppoLabel().paintImmediately(this.getGruppoLabel().getVisibleRect());
		
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

}
