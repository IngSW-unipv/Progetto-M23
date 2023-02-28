package IT.unipv.progettoM23.view;

  import java.awt.*;
  import javax.swing.*;

  public class CercaPanel extends CartaPanel {
      
	  private static final long serialVersionUID = 1L;
	  private JLabel testo;
	  private JTextField userTextField;
	  private ContainerPanel cp;
	  private JButton indietro,cerca;


	  public CercaPanel() {
	
		this.setKey("cerca");
	    
		this.setLayout(new BorderLayout());
		
		Color white=new Color(255,255,255);

		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp,BorderLayout.NORTH);
		
		

	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));

	    testo = new JLabel("Inserisci il codice fiscale:");
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,30));
	    cp.add(testo);

	    userTextField = new JTextField(25);
	    cp.add(userTextField);
	    
	    cerca=new JButton("cerca");
	    cp.add(cerca);
	    
	    this.add(cp,BorderLayout.CENTER);


	  }    
	  
	  
	  public JButton getCercaButton() {
		  return this.cerca;
	  }
	  
	  public String getContenutoBarra() {
		  return this.userTextField.getText();
	  }
	  
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }
	  
   }