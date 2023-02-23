package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

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
	private DonazioneDAO dDAO;
	private RichiestaSaccaDAO rDAO;
	private LoginRegistrazioneDAO lrDAO;
	private DonatoreDAO donDAO;
    
	private Donatore donatoreCercato;
	//private LoginRegistrazione lrDonatoreCercato;
	
	public ModelCentroDonazioni() {
		pDAO=new PrenotazioneDAO();
		dDAO=new DonazioneDAO();
		rDAO=new RichiestaSaccaDAO();
		lrDAO=new LoginRegistrazioneDAO();
		donDAO=new DonatoreDAO();
	}
	
	
	public String[][] getTodaysPrenotazioni() {
		
		return pDAO.getArrayPrenotazioni(Date.valueOf(LocalDate.now()));
	}
	
	public String[][] getPrenotazioniGiorno(Date d){
		return pDAO.getArrayPrenotazioni(d);
	}
	
	
	public void confermaPrenotazione(String cf) {
		
		Donazione don=new Donazione(cf,Date.valueOf(LocalDate.now()));
		dDAO.inserisciDonazione(don);
	}
	
	
	
	public int[] getNumSacche() {
		ControllerSacche cs=new ControllerSacche();
		
		int[] numSacche = new int[4];
		
		numSacche[0]=cs.getNumSacche(GruppoSanguigno.A);
		numSacche[1]=cs.getNumSacche(GruppoSanguigno.B);
		numSacche[2]=cs.getNumSacche(GruppoSanguigno.AB);
		numSacche[3]=cs.getNumSacche(GruppoSanguigno.ZERO);
		
		
		return numSacche;
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
	
}
