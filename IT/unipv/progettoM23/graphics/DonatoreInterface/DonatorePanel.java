package IT.unipv.progettoM23.graphics.DonatoreInterface;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import IT.unipv.progettoM23.graphics.ContainerPanel;
import IT.unipv.progettoM23.persona.Donatore;


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
		
		DefaultListModel<String> dlm=new DefaultListModel<>();

		dlm.addElement("ciao");
		dlm.addElement("prova");
		dlm.addElement("lista");
		dlm.addElement("ciao");
		
		JList<String> lista=new JList<>(dlm);
	    cp.add(lista);
	    
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
        
        
    	
        
        
    	cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
    	testo=new JLabel("La tua prossima donazione: ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
		testo.setForeground(white);
        cp.add(testo);  
        this.add(cp);
    	
    	
    
    	
		
	}
}
