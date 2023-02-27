package IT.unipv.progettoM23.graphics;

  import java.awt.*;
  import javax.swing.*;

  
  public class MenuPanel extends CartaPanel  {
      
	  private static final long serialVersionUID = 1L;
	  private JButton indietro;
	  private JButton CDButton;
	  private JButton VPButton;
	  private JButton CSButton;
	  private JButton VRButton;
	  private ContainerPanel cp;


	  
	  public MenuPanel() {
		  
		this.setKey("menu");
	    
	    this.setBackground(new Color(100,0,0));

	    this.setLayout(new GridLayout(0,1));
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
	    
	    
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
	  
	  
	  
	  public JButton getButton1() {
		  return this.CDButton;
	  }
	  
	  public JButton getButton2() {
		  return this.VPButton;
	  }
	  
	  public JButton getButton3() {
		  return this.CSButton;
	  }
	  
	  public JButton getButton4() {
		  return this.VRButton;
	  }
	  
	  
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }
	 
  }
  
  
  
  
  