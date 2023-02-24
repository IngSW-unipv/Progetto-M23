package IT.unipv.progettoM23.graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.sacche.ControllerSacche;

public class SacchePanel extends CartaPanel {
	
	private JLabel testo,testoA,testoB,testoAB,testo0;
	private ContainerPanel cp;
	private JButton indietro;

    
	public SacchePanel() {
		
		this.setKey("sacche");
		
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
	    
	    
	   
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testoA = new JLabel();
	    
	    testoA.setFont(new Font("Dialog",Font.PLAIN,30));
	    testoA.setForeground(white);
	    cp.add(testoA);
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testoB = new JLabel();
	    
	    testoB.setFont(new Font("Dialog",Font.PLAIN,30));
	    testoB.setForeground(white);
	    cp.add(testoB);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testoAB = new JLabel();
	    
	    testoAB.setFont(new Font("Dialog",Font.PLAIN,30));
	    testoAB.setForeground(white);
	    cp.add(testoAB);
	    
	    this.add(cp);
	    
	    
	    

	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));

	    testo0 = new JLabel();
	    
	    testo0.setFont(new Font("Dialog",Font.PLAIN,30));
	    testo0.setForeground(white);
	    cp.add(testo0);
	    
	    this.add(cp);
	   
		
	}
	
	
	public void visualizzaNumSacche(int[] num) {
		
		this.testoA.setText("  A: "+num[0]);
		this.testoA.paintImmediately(testoA.getVisibleRect());
		
		this.testoB.setText("  B: "+num[1]);
		this.testoB.paintImmediately(testoB.getVisibleRect());
		
		this.testoAB.setText("  AB: "+num[2]);
		this.testoAB.paintImmediately(testoAB.getVisibleRect());
		
		this.testo0.setText("  0: "+num[3]);
		this.testo0.paintImmediately(testo0.getVisibleRect());
		
	}
	
	
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }
}
