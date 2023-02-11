package IT.unipv.progettoM23.graphics;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;


public class LoginPanel extends JPanel implements ActionListener{
    
	private static final long serialVersionUID = 1L;
	private JLabel userLabel;
	private JTextField userTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton indietro,loginButton,regButton;
	private ContainerPanel cp;
	
	
	
	public LoginPanel( ){
		
		this.setLayout(new GridLayout());
		
		Color white=new Color(255,255,255);
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		indietro =new JButton("Indietro");
		cp.add(indietro);
		this.add(cp);
		
		
		
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
	    
	    this.add(cp);
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));

	    loginButton = new JButton("Accedi");
	    loginButton.addActionListener(this);
	    cp.add(loginButton);
	    
	    regButton = new JButton("Registrati");
	    regButton.addActionListener(this);
	    cp.add(regButton);
	    
	    this.add(cp);
	    
	    
	    this.setBackground(new Color(100,0,0));
	}
	
	
	  public void actionPerformed(ActionEvent e) {
		  
		  if(e.getSource()==loginButton) {
		  
			  String codFis = userTextField.getText();
			  String password = passwordTextField.getText();
			  
		  }
		  
	  }

}
