package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.sql.Date;
import java.time.LocalDate;

import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.sacche.ControllerSacche;

public class CentroNazionaleSangue {
	
	ControllerSacche cs;
    
	public CentroNazionaleSangue() {}
	
	
	public int[] getNumSacche() {
		cs=new ControllerSacche();
		
		int[] numSacche = new int[4];
		
		numSacche[0]=cs.getNumSacche(GruppoSanguigno.A);
		numSacche[1]=cs.getNumSacche(GruppoSanguigno.B);
		numSacche[2]=cs.getNumSacche(GruppoSanguigno.AB);
		numSacche[3]=cs.getNumSacche(GruppoSanguigno.ZERO);
		
		
		return numSacche;
	}
	
	
	
	
	public boolean registraDonazione(String cf) {
		
		if(cf!=null) {
		
			Date today=Date.valueOf(LocalDate.now());
			Donazione donazione=new Donazione(cf,today);
			DonazioneDAO dDAO= new DonazioneDAO();
			
			return dDAO.inserisciDonazione(donazione);
			
		}
		else {
			return false;
		}
	}
}
