package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

import IT.unipv.progettoM23.persona.GruppoSanguigno;


public class RegistrationPanel extends CartaPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel testo;
	private JTextField nomeTF,cognomeTF,giornoTF,meseTF,annoTF,userTF,passwordTF;
	private JRadioButton buttonM,buttonF,buttonA,buttonB,buttonAB,buttonZ;
	private ButtonGroup buttonsMF,groupButtons;
	private JButton indietro,continuaButton;
	private ContainerPanel cp,cp1;
	
	
	
	public RegistrationPanel() {
		
		this.setKey("registrazione");
	
		this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
		
		
		Color white=new Color(255,255,255);
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("Codice Fiscale:");
	    testo.setForeground(white);
	    cp.add(testo);

	    userTF = new JTextField(25);
	    cp.add(userTF);
	    
	    this.add(cp);
	    
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
 
	    testo = new JLabel("Password:");
	    testo.setForeground(white);
	    cp.add(testo);

	    passwordTF = new JTextField(25);
	    cp.add(passwordTF);
	    
	    this.add(cp);
		
		
	    
	
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("Nome: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    nomeTF=new JTextField(25);
	    cp.add(nomeTF);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    
	    testo = new JLabel("Cognome: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    cognomeTF=new JTextField(25);
	    cp.add(cognomeTF);
	        
	    this.add(cp);
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    
	    testo = new JLabel("Sesso: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    
	    cp1=new ContainerPanel(new GridLayout(1,1));
	    
	    buttonM = new JRadioButton("M");
	    buttonF = new JRadioButton("F");
	    
	    buttonsMF=new ButtonGroup();
	    buttonsMF.add(buttonM);
	    buttonsMF.add(buttonF);
	    
	    cp1.add(buttonM);
	    cp1.add(buttonF);
	    
	    cp.add(cp1);
        
        this.add(cp);
        
        
        
        
        
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
        
	    testo = new JLabel("Gruppo: ");
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
	    
	    testo = new JLabel("Anno di nascita (GG/MM/AAAA): ");
	    testo.setForeground(white);
	    cp.add(testo); 
	    
	    giornoTF=new JTextField(2);
	    cp.add(giornoTF);
	    
	    meseTF=new JTextField(2);
	    cp.add(meseTF);
	    
	    annoTF=new JTextField(4);
	    cp.add(annoTF);
	    
	    this.add(cp);
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));
	    continuaButton=new JButton("Continua");
	    continuaButton.setPreferredSize(new Dimension(100,25));
	    cp.add(continuaButton);
	    
	    this.add(cp);
	    
	    
		
	}
	
	
	
	public JButton getContinuaButton() {
		return this.continuaButton;
	}
	
	public String getContenutoCF() {
		return userTF.getText();
	}
		
	public String getContenutoPSW() {
		return passwordTF.getText();
	}
	
	public String getContenutoNome() {
		return nomeTF.getText();
	}
	
	public String getContenutoCogn() {
		return cognomeTF.getText();
	}
	
	public String getContenutoSesso() {
		if(buttonM.isSelected()) {
			return "M";
		}
		else if (buttonF.isSelected()) {
			return "F";
		}
		else {
			return null;
		}
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
	
	
	public Date getContenutoData() {
		
		try {
		    return Date.valueOf(annoTF.getText()+"-"+meseTF.getText()+"-"+giornoTF.getText());
		}
		
		catch(Exception e) {
			return null;
		}
	}
	
	
	
	public JButton getIndietroButton() {
		return indietro;
	}

}
