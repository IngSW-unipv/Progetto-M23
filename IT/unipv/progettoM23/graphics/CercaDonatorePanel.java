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

public class CercaDonatorePanel extends JPanel{
	
	private JLabel testo;
	private ContainerPanel cp;
	private JButton indietro;
	
	
	public CercaDonatorePanel(Donatore d) {
		
		
        this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Cognome: "+d.getCognome());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Nome: "+d.getNome());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Codice Fiscale: "+d.getcodFiscale());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Data di Nascita(AAAA/MM/GG):  "+d.getData());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Sesso: "+d.getSesso());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Gruppo: "+d.getGruppo());
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel("    Donazioni: ");
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo);
	    
		DefaultListModel<Date> dlm=new DefaultListModel<>();
		
		DonazioneDAO dDAO = new DonazioneDAO();
		ArrayList<Donazione> donazioni = dDAO.selectDonazioni(d.getcodFiscale());
        
        for(Donazione don:donazioni) {
        	dlm.addElement(don.getData());
        }
		
		JList<Date> lista=new JList<>();//dlm);
		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(new Dimension(100,60));
	    cp.add(scrollPane);
	    
    	this.add(cp);
    	
    	
    	
    	
    	
    	cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
    	this.add(cp);
		
	}

}
