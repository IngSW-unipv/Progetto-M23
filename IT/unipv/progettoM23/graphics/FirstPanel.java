package IT.unipv.progettoM23.graphics;

import java.awt.*;
import javax.swing.*;


public class FirstPanel extends CartaPanel {
	
	private static final long serialVersionUID = 1L;
	private ContainerPanel cp,cp1;
	private JButton iDonatoreButton,iOspedaleButton,iCentroButton;
    
	public FirstPanel() {
		
		this.setKey("principale");
	    
	    this.setBackground(new Color(100,0,0));

	    this.setLayout(new BorderLayout());
	    
	    cp=new ContainerPanel(null);
	    cp.setPreferredSize(new Dimension(100,100));
	    this.add(cp,BorderLayout.NORTH);
	    
	    
	    
	    cp1=new ContainerPanel(new GridLayout(0,1));
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    iDonatoreButton=new JButton("Interfaccia Donatore");
	    iDonatoreButton.setPreferredSize(new Dimension(500,45));
	    cp.add(iDonatoreButton);
	    cp1.add(cp);
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    iCentroButton=new JButton("Interfaccia Centro Donazioni");
	    iCentroButton.setPreferredSize(new Dimension(500,45));
	    cp.add(iCentroButton);
	    cp1.add(cp);
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    iOspedaleButton=new JButton("Interfaccia Ospedale");
	    iOspedaleButton.setPreferredSize(new Dimension(500,45));
	    cp.add(iOspedaleButton);
	    cp1.add(cp);
	    
	    this.add(cp1,BorderLayout.CENTER);
	}
	
	
	
	public JButton getIDonatoreButton() {
		return this.iDonatoreButton;
	}
	
	
	public JButton getICentroButton() {
		return this.iCentroButton;
	}
	
	
	public JButton getIOspedaleButton() {
		return this.iOspedaleButton;
	}
	
	
}
