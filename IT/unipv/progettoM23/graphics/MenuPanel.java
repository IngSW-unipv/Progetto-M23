package IT.unipv.progettoM23.graphics;

  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import javax.swing.*;

  public class MenuPanel extends JPanel  {

	  
	  private JButton CDButton;
	  private JButton VPButton;
	  private JButton CSButton;
	  private JButton VRButton;
	  private ContainerPanel cp;


	  
	  public MenuPanel() {
	    
	    this.setBackground(new Color(100,0,0));

	    this.setLayout(new GridLayout(0,1));
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    CDButton = new JButton("Cerca Donatore");
	    cp.add(CDButton);
	    this.add(cp);
	        
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    VPButton = new JButton("Visualizza Prenotazioni");
	    cp.add(VPButton);
	    this.add(cp);

	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    CSButton = new JButton("Controlla Sacche");
	    cp.add(CSButton);
	    this.add(cp);


	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    VRButton = new JButton("Visualizza Richiesta");
	    cp.add(VRButton);
	    this.add(cp);
	  }
	
  }