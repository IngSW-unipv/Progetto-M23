package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import IT.unipv.progettoM23.graphics.DonatoreInterface.DonatorePanel;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import IT.unipv.progettoM23.persona.LoginRegistrazione;
import IT.unipv.progettoM23.persona.LoginRegistrazioneDAO;

public class ControllerLoginPanel{
    
	public ControllerLoginPanel() {}
	
	
	public JPanel ProssimoPannello(LoginRegistrazione lr) {
		DonatoreDAO dDAO = new DonatoreDAO();
		Donatore donatore =dDAO.selectDonatore(lr.getCodiceFiscale());
		DonatorePanel dp = new DonatorePanel(donatore);
		
		return dp;
		
		
	} //fa controlli e chiama pannello registrazione o donatore
	
	public void chiamaPannelloPrecedente() {} 
	
	public void chiamaPannelloReg() {} 
	public void chiamaPannelloDon() {}
	
	
	public String controllaUtente(LoginRegistrazione lr) {
		
		LoginRegistrazioneDAO lrDAO = new LoginRegistrazioneDAO();
		
		if (lrDAO.verificaCodiceFiscale(lr.getCodiceFiscale())==false) {
			
			return "Codice Fiscale Errato";
			
		}
		else if (lrDAO.verificaUtente(lr)==false){
			return "Password Errata";
			
			
		}
		else {
			ProssimoPannello(lr);
			return "Login Effettuato";
		}
		
		
	} //

	
	
//   se codice fiscale uguale al codice fiscale nel
//  database allora controlla la password altrimenti stampa 'codice fiscale errato o utente non registrato
//  se il codice fiscale è presente allora controlla la password, se password uguale a password database
//  allora chiama chiamaPannelloDon() altrimenti stampa password errata. 	
	
	
	
	
}
