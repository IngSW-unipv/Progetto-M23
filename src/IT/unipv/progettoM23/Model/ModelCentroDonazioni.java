package IT.unipv.progettoM23.Model;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import IT.unipv.progettoM23.Model.CentroNazionaleSangue.CentroNazionaleSangue;
import IT.unipv.progettoM23.Model.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.Model.persona.Donatore;
import IT.unipv.progettoM23.Model.persona.GruppoSanguigno;
import IT.unipv.progettoM23.database.DonatoreDAO;
import IT.unipv.progettoM23.database.DonazioneDAO;
import IT.unipv.progettoM23.database.LoginRegistrazioneDAO;
import IT.unipv.progettoM23.database.PrenotazioneDAO;
import IT.unipv.progettoM23.database.RichiestaSaccaDAO;


public class ModelCentroDonazioni {
	
	private PrenotazioneDAO pDAO;
	private RichiestaSaccaDAO rDAO;
	private LoginRegistrazioneDAO lrDAO;
	private DonatoreDAO donDAO;
	private DonazioneDAO dDAO;
    
	private Donatore donatoreCercato;
	private CentroNazionaleSangue centro;
	
	
	public ModelCentroDonazioni() {
		pDAO=new PrenotazioneDAO();
		rDAO=new RichiestaSaccaDAO();
		lrDAO=new LoginRegistrazioneDAO();
		donDAO=new DonatoreDAO();
		dDAO=new DonazioneDAO();
		
		centro=new CentroNazionaleSangue();
	}
	
	
	public String[][] getTodaysPrenotazioni() {
		
		return pDAO.getArrayPrenotazioni(Date.valueOf(LocalDate.now()));
	}
	
	public String[][] getPrenotazioniGiorno(Date d){
		return pDAO.getArrayPrenotazioni(d);
	}
	

	
	public int[] getNumSacche() {
		
		return this.centro.getNumSacche();
	}
	
	
	public String[][] getRichiesteEffettuate(){
		return rDAO.getArrayRichieste();	
	}
	
	
    public boolean cfValido(String cf) {
    	return (cf.length()==16);
    }
    
    
	public boolean verificaCF(String cf){      	
		return( lrDAO.verificaCodiceFiscale(cf));
	}
	
	
	public void selectDonatore(String cf) {
		this.donatoreCercato=donDAO.selectDonatore(cf);
	}
	
	
	public Donatore getDonatoreCercato() {
		return this.donatoreCercato;
	}
	
	
	public ArrayList<Donazione> getDonazioniDonatore(){  
		return dDAO.selectDonazioni(this.donatoreCercato.getcodFiscale());
	}
	
	
	public boolean registraDonazione(String cf) {
	
		return this.centro.registraDonazione(cf);
	}
	
	
	public void aggiungiSacca(String cf) {
		GruppoSanguigno g=donDAO.selectDonatore(cf).getGruppo();
		
		this.centro.getControllerSacche().cambiaNumSacche(g, 1);
	}
	
	
	public void soddisfaRichieste() {
		this.centro.soddisfaRichieste();
	}
	
}
