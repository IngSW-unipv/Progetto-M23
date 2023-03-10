package IT.unipv.progettoM23.Model;

import java.sql.Date;
import java.util.ArrayList;

import IT.unipv.progettoM23.Model.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.Model.persona.Donatore;
import IT.unipv.progettoM23.Model.persona.GruppoSanguigno;
import IT.unipv.progettoM23.Model.persona.LoginRegistrazione;
import IT.unipv.progettoM23.Model.persona.Prenotazione;
import IT.unipv.progettoM23.database.DonatoreDAO;
import IT.unipv.progettoM23.database.DonazioneDAO;
import IT.unipv.progettoM23.database.LoginRegistrazioneDAO;
import IT.unipv.progettoM23.database.PrenotazioneDAO;

public class ModelDonatore {
	
    private LoginRegistrazione login;
    private Donatore donatoreLoggato;
    
    private LoginRegistrazioneDAO lrDAO;
    private DonatoreDAO dDAO;
    private PrenotazioneDAO pDAO;
    private DonazioneDAO donDAO;


	
	  
	public ModelDonatore() {
		this.lrDAO = new LoginRegistrazioneDAO();
		this.dDAO = new DonatoreDAO();
		this.pDAO = new PrenotazioneDAO();
		this.donDAO = new DonazioneDAO();
		
	}
	
	
	
	public void setLogin(String cf,String psw) {             ///// chiamata quando l user preme il pulsante login, dati passati da controller
		
		login=new LoginRegistrazione(cf,psw);
	}
	
	
	
	public boolean verificaCF(){            ///step 1 dopo aver premuto pulsante login, se false controller manda messaggio popup
		
		return( lrDAO.verificaCodiceFiscale(login.getCodiceFiscale()));
	}
	
	
	
	public boolean verificaPSW(){           ///step 2 dopo aver premuto pulsante login, se false controller manda messaggio popup
		
		return( lrDAO.verificaUtente(login));
	}

	

	
	public void effettuaLogin(LoginRegistrazione l) {             ////step 3, ora abbiamo il donatore loggato
		
		this.donatoreLoggato=dDAO.selectDonatore(this.login.getCodiceFiscale());
	}
	
	
	
	public boolean puoDonare() {                               //// step 1 quando l user preme il pulsante prenota 
		return this.donatoreLoggato.puòDonare();
	}
	
	
	public boolean puoPrenotare() {                    ///// step 2 quando l user preme il pulsante prenota, controlla se ha già prenotazioni future
		return this.donatoreLoggato.puoPrenotare();
	}	
    
	
	
	public void assegnaPrenotazione() {                     ///step3 chiamata se step1 e step2 sono true, crea la prenotazione per il donatore e la aggiunge al database
		pDAO.inserisciPrenotazione(this.donatoreLoggato.creaPrenotazione());
	}
	
	
	
	public void cancellaPrenotazione() {
		pDAO.cancellaPrenotazione(getPrenotazioneDonatore());
	}                ///serve metodo cancellaPrenotazione su PrenotazioneDAO, chiamato quando user preme pulsante cancella
	
	
	
	
	public void creaDonatore(String cf,String p,String c,String n, Date d, String s,GruppoSanguigno g) {
		this.donatoreLoggato=new Donatore(cf,c,n,d,s,g);
		this.login=new LoginRegistrazione(cf,p);
		
		System.out.println(lrDAO.inserisciUtente(login));
		System.out.println(dDAO.inserisciDonatore(this.donatoreLoggato)); //metodo da implementare su donatoreDAO
	}
	
	
	
	
	
	public ArrayList<Donazione> getDonazioniDonatore(){                          ////verrà passato al controller e poi all int grafica, solo per visualizzare i dati
		return donDAO.selectDonazioni(this.donatoreLoggato.getcodFiscale());
	}
	
	
	public Donatore getDonatore() {            /// verrà passato a int grafica, solo per visualizzare
		return this.donatoreLoggato;
	}

	
	
	public Prenotazione getPrenotazioneDonatore() {    //verrà passato a int grafica, solo per visualizzare
		if (!this.donatoreLoggato.puoPrenotare()) {
		    return pDAO.selectUltimaPrenotazione(this.donatoreLoggato.getcodFiscale());
		}
		else {
			return null;
		}
	}
	
    
	public LoginRegistrazione getLogin() {
		return this.login;
	}
	
	
	
	
	////// metodi che controllano il formato dei dati nella registrazione
	
    public boolean cfValido(String cf) {
    	return (cf.length()==16);
    }
    
    public boolean pswValida(String psw) {
    	return (psw.length()>7)&&(psw.length()<20);
    }
    
    public boolean nomeValido(String n) {
    	return (n.length()!=0);
    }
    
    public boolean cognomeValido(String c) {
    	return (c.length()!=0);
    }
    
    public boolean sessoValido(String s) {
    	return s!=null;
    }
    
    public boolean gruppoValido(GruppoSanguigno g) {
    	return g!=null;
    } 
    
    public boolean dataValida(Date d) {
    	return d!=null;
    }
    
	
}