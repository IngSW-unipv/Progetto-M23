package IT.unipv.progettoM23.view;


import java.awt.*;
import javax.swing.*;


public class LoginPanel extends CartaPanel {
    
	private static final long serialVersionUID = 1L;
	private JLabel userLabel;
	private JTextField userTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton indietro,loginButton,registrButton;
	private ContainerPanel cp;
	
	
	public LoginPanel(){
		
		this.setKey("login");
		
		this.setLayout(new BorderLayout());
		
		Color white=new Color(255,255,255);
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp,BorderLayout.NORTH);
		
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    userLabel = new JLabel("Codice Fiscale:");
	    userLabel.setForeground(white);
	    cp.add(userLabel);

	    userTextField = new JTextField(25);
	    cp.add(userTextField);

	    passwordLabel = new JLabel("Password:");
	    passwordLabel.setForeground(white);
	    cp.add(passwordLabel);

	    passwordTextField = new JPasswordField(25);
	    cp.add(passwordTextField);
	    this.add(cp,BorderLayout.CENTER);

	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));
	    loginButton = new JButton("Accedi");
	    cp.add(loginButton);
	    
	    registrButton = new JButton("Registrati");
	    cp.add(registrButton);
	    
	    this.add(cp,BorderLayout.SOUTH);
	    
	    
	    this.setBackground(new Color(100,0,0));
	}
	
	
	
	
	public JButton getAccediButton() {
		return this.loginButton;
	}
	
	public String getContenutoCF() {
		return userTextField.getText();
	}
		
	public String getContenutoPSW() {
		return passwordTextField.getText();
	}
	  
	public JButton getRegistraButton() {
		return this.registrButton;
	}
	
	public JButton getIndietroButton() {
		return indietro;
	}

	

	

	 

}
