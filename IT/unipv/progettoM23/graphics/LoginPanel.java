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
	private JButton loginButton;
	
	public LoginPanel(){
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Color white=new Color(255,255,255);
		
		
	    userLabel = new JLabel("Codice Fiscale:");
	    userLabel.setForeground(white);
	    this.add(userLabel);

	    userTextField = new JTextField(25);
	    this.add(userTextField);

	    passwordLabel = new JLabel("Password:");
	    passwordLabel.setForeground(white);
	    this.add(passwordLabel);

	    passwordTextField = new JPasswordField(25);
	    this.add(passwordTextField);

	    loginButton = new JButton("Accedi");
	    loginButton.addActionListener(this);
	    this.add(loginButton);
	    
	    
	    this.setBackground(new Color(100,0,0));
	}
	
	
	  public void actionPerformed(ActionEvent e) {
		  String codFis = userTextField.getText();
		  String password = passwordTextField.getText();
		  
		  try {
			  DonatoreDAO dd=new DonatoreDAO();
			  Donatore utente=dd.selectDonatore(codFis);
			  
			  if (utente.getcodFiscale()!=codFis) {
				  
			  }
		  }
		  
		  catch(SQLException sqle) {
			  
			  //chiama la pagina registrazione
		  }
		  
	  }

}
