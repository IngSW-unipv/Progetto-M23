package IT.unipv.progettoM23.graphics.registrazine;

import java.awt.*;
import javax.swing.*;


public class RegistrationPanel extends JPanel{
	
	private JLabel testo;
	private JTextField nomeTF,cognomeTF,giornoTF,meseTF,annoTF;
	private MFbuttonsPanel buttonsMF;
	private GroupsButtonsPanel buttonsGroup;
	private JButton continuaButton;
	
	
	
	public RegistrationPanel() {
	
		this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
		
		
		Color white=new Color(255,255,255);
		
		
		
		
		
		
		ContainerPanel cp=new ContainerPanel();
		
	    testo = new JLabel("Nome: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    nomeTF=new JTextField(25);
	    cp.add(nomeTF);
	    
	    this.add(cp);
	    
	    
	    
	    
	    
	    cp=new ContainerPanel();
	    
	    testo = new JLabel("Cognome: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    cognomeTF=new JTextField(25);
	    cp.add(cognomeTF);
	        
	    this.add(cp);
	    
	    
	    
	    
	    cp=new ContainerPanel();
	    
	    testo = new JLabel("Sesso: ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
        buttonsMF=new MFbuttonsPanel();
        cp.add(buttonsMF);
        
        this.add(cp);
        
        
        
        
	    cp=new ContainerPanel();
        
	    testo = new JLabel("Gruppo: ");
	    testo.setForeground(white);
	    cp.add(testo);       
        
        buttonsGroup=new GroupsButtonsPanel();
        cp.add(buttonsGroup);
        
        this.add(cp);
        
        
        
        
	    cp=new ContainerPanel();
	    
	    testo = new JLabel("Anno di nascita: ");
	    testo.setForeground(white);
	    cp.add(testo); 
	    
	    giornoTF=new JTextField(2);
	    cp.add(giornoTF);
	    
	    meseTF=new JTextField(2);
	    cp.add(meseTF);
	    
	    annoTF=new JTextField(2);
	    cp.add(annoTF);
	    
	    this.add(cp);
	    
	    
	    
	    cp=new ContainerPanel();
	    continuaButton=new JButton("Continua");
	    continuaButton.setPreferredSize(new Dimension(100,25));
	    cp.add(continuaButton);
	    
	    this.add(cp);
	    
	    
		
	}

}
