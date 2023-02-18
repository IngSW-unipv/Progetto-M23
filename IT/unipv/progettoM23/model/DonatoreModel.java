package IT.unipv.progettoM23.model;

import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import IT.unipv.progettoM23.persona.LoginRegistrazione;
import IT.unipv.progettoM23.persona.LoginRegistrazioneDAO;


public class DonatoreModel {
	
	Donatore donatoreLoggato;
	LoginRegistrazione login;
	
	public DonatoreModel() {}
    
	
	
	
	public void getLogin(String cf,String psw) {             ///// chiamata quando l user preme il pulsante login, dati passati da controller
		
		login=new LoginRegistrazione(cf,psw);
	}
	
	
	public boolean tryCF() {
		
		LoginRegistrazioneDAO ldao=new LoginRegistrazioneDAO();
		return ldao.verificaCodiceFiscale(this.login.getCodiceFiscale());
	}
	
	
	public boolean tryPSW() {
		
		LoginRegistrazioneDAO ldao=new LoginRegistrazioneDAO();
		return ldao.verificaUtente(this.login);
	}
	
	
	
	public void effettuaLogin(LoginRegistrazione l) {
		
		DonatoreDAO dd=new DonatoreDAO();
		
		this.donatoreLoggato=dd.selectDonatore(this.login.getCodiceFiscale());
	}
	
	
	
	
	
}
