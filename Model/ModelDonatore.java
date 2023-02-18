package Model;

import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import IT.unipv.progettoM23.persona.LoginRegistrazione;
import IT.unipv.progettoM23.persona.LoginRegistrazioneDAO;

public class ModelDonatore {
	
	private static ModelDonatore jModelDonatore;
    private Donatore donatore;
    private LoginRegistrazioneDAO lrDAO;
    private Boolean b;
    private LoginRegistrazione lr;
    private Donatore donatoreLoggato;
    private DonatoreDAO dDAO;


  
private ModelDonatore() {
	this.lrDAO = new LoginRegistrazioneDAO();
	this.dDAO = new DonatoreDAO();
	
}

public boolean VerificaUtente1(LoginRegistrazione lr){
	
	b= lrDAO.verificaCodiceFiscale(lr.getCodiceFiscale());
	return b;
	
	
}

public boolean VerificaUtente2(LoginRegistrazione lr){
	
	b= lrDAO.verificaUtente(lr);
	return b;
}


//una volta loggato

public Donatore PrendiDatiDonatore(LoginRegistrazione lr) {
	
	return donatoreLoggato = dDAO.selectDonatore(lr.getCodiceFiscale());
}



}