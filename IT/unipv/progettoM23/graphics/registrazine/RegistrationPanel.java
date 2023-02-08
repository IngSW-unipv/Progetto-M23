package IT.unipv.progettoM23.graphics.registrazine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import IT.unipv.progettoM23.graphics.ContainerPanel;


public class RegistrationPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel testo;
	private JTextField nomeTF,cognomeTF,giornoTF,meseTF,annoTF;
	private MFbuttonsPanel buttonsMF;
	private GroupsButtonsPanel buttonsGroup;
	private JButton indietro,continuaButton;
	private ContainerPanel cp;
	
	
	
	public RegistrationPanel() {
	
		this.setLayout(new GridLayout(0,1));
		
		this.setBackground(new Color(100,0,0));
		
		
		Color white=new Color(255,255,255);
		
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
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
	    
        buttonsMF=new MFbuttonsPanel();
        cp.add(buttonsMF);
        
        this.add(cp);
        
        
        
        
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
        
	    testo = new JLabel("Gruppo: ");
	    testo.setForeground(white);
	    cp.add(testo);       
        
        buttonsGroup=new GroupsButtonsPanel();
        cp.add(buttonsGroup);
        
        this.add(cp);
        
        
        
        
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    
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
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    continuaButton=new JButton("Continua");
	    continuaButton.setPreferredSize(new Dimension(100,25));
	    cp.add(continuaButton);
	    
	    this.add(cp);
	    
	    
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		//prende dati quando si preme il pulsante
		
	}

}
