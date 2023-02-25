package IT.unipv.progettoM23.graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class OspedalePanel extends CartaPanel{
    
	private ContainerPanel cp,cp1;
	private JButton indietro,mandaRichiesta;
	private JLabel testo;
	private JTextField cfPaziente,numSacche;
	private ButtonGroup groupButtons;
	private JRadioButton buttonA,buttonB,buttonAB,buttonZ;
	
	public OspedalePanel() {
		
		this.setKey("ospedale");
		
		this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
	
		Color white=new Color(255,255,255);		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("Inserire Codice Fiscale del Paziente: ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    cfPaziente=new JTextField(25);
	    
	    cp.add(cfPaziente);
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
 
	    testo = new JLabel("Inserire Gruppo Richiesto: ");
		testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    testo.setForeground(white);
	    cp.add(testo);	
		
	    cp1=new ContainerPanel(new GridLayout(1,1));
        
	    buttonA = new JRadioButton("A");
	    buttonB = new JRadioButton("B");
	    buttonAB = new JRadioButton("AB");
	    buttonZ = new JRadioButton("0");
	    
	    groupButtons=new ButtonGroup();
	    groupButtons.add(buttonA);
	    groupButtons.add(buttonB);
	    groupButtons.add(buttonAB);
	    groupButtons.add(buttonZ);
	    
	    cp1.add(buttonA);
	    cp1.add(buttonB);
	    cp1.add(buttonAB);
	    cp1.add(buttonZ);
        
	    cp.add(cp1);
	    
	    this.add(cp);
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("Inserire Quantità: ");
	    testo.setForeground(white);
		testo.setFont(new Font("Dialog",Font.PLAIN,20));

	    cp.add(testo);
	    
	    numSacche=new JTextField(5);
	    
	    cp.add(numSacche);
	    
	    this.add(cp);

	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));
		mandaRichiesta =new JButton("Manda Richiesta");
		cp.add(mandaRichiesta);
		this.add(cp);
	    
		
	}
	
	
	
	
	public String getContenutoCF() {
		return cfPaziente.getText();
	}
	
	
	public GruppoSanguigno getContenutoGruppo() {
		
		if(buttonA.isSelected()) {
			return GruppoSanguigno.A;
		}
		else if(buttonB.isSelected()) {
			return GruppoSanguigno.B;
		}
		else if(buttonAB.isSelected()) {
			return GruppoSanguigno.AB;
		}
		else if(buttonZ.isSelected()) {
			return GruppoSanguigno.ZERO;
		}
		else {
			return null;
		}
	}
	
	
	public int getContenutoQuantita() {
		String s= numSacche.getText();
		
		try {
			int i=Integer.valueOf(s);
			
			return i;
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	
	
	public JButton getMandaButton() {
		return this.mandaRichiesta;
	}
	
	
	
	public JButton getIndietroButton() {
		return indietro;
	}
}
