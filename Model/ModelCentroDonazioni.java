package Model;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import IT.unipv.progettoM23.CentroNazionaleSangue.CentroNazionaleSangue;
import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.ospedale.RichiestaSacca;
import IT.unipv.progettoM23.ospedale.RichiestaSaccaDAO;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.persona.LoginRegistrazione;
import IT.unipv.progettoM23.persona.LoginRegistrazioneDAO;
import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;
import IT.unipv.progettoM23.sacche.ControllerSacche;

public class ModelCentroDonazioni {
	
	private PrenotazioneDAO pDAO;
	private RichiestaSaccaDAO rDAO;
	private LoginRegistrazioneDAO lrDAO;
	private DonatoreDAO donDAO;
	private DonazioneDAO dDAO;
    
	private Donatore donatoreCercato;
	private CentroNazionaleSangue centro;
	//private LoginRegistrazione lrDonatoreCercato;
	
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
	
	
//	public void confermaPrenotazione(String cf) {
//		
//		this.centro.confermaPrenotazione(cf);
//	}
//	
	
	
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
	
}
