package IT.unipv.progettoM23.graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.sacche.ControllerSacche;

public class SacchePanel extends JPanel {
	
	private JLabel testo;
	private ContainerPanel cp;
	private JButton indietro;

    
	public SacchePanel() {
		
		this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
			
		Color white=new Color(255,255,255);
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));

	    testo = new JLabel("  Sacche rimanenti per ogni gruppo:");
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
	    ControllerSacche contrSacche=new ControllerSacche();
	    
	    
	   
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testo = new JLabel("  A: "+contrSacche.getNumSacche(GruppoSanguigno.A));
	    
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testo = new JLabel("  B: "+contrSacche.getNumSacche(GruppoSanguigno.B));
	    
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testo = new JLabel("  AB: "+contrSacche.getNumSacche(GruppoSanguigno.AB));
	    
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    

	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testo = new JLabel("  0: "+contrSacche.getNumSacche(GruppoSanguigno.ZERO));
	    
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    this.add(cp);
	    
	    
	    
		
		
		
		
		
		
		
	}
}
